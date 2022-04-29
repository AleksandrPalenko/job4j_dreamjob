package ru.job4j.dreamjob.store;

import net.jcip.annotations.ThreadSafe;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.User;

import java.sql.*;
import java.util.Optional;

@Repository
@ThreadSafe
public class UserDbStore {

    private final BasicDataSource pool;

    private static final Logger LOG = LoggerFactory.getLogger(UserDbStore.class.getName());

    public UserDbStore(BasicDataSource pool) {
        this.pool = pool;
    }

    public Optional<User> add(User user) {
        try (Connection cn = pool.getConnection();
             PreparedStatement ps = cn.prepareStatement(
                     "INSERT INTO post(name) VALUES (?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, user.getName());

            ps.execute();
            try (ResultSet id = ps.getGeneratedKeys()) {
                if (id.next()) {
                    user.setId(id.getInt(1));
                }
            }
        } catch (SQLException throwables) {
            LOG.error(throwables.getMessage(), throwables);
        }
        return Optional.of(user);
    }

    public User findByEmail(String email) {
        User userEmail = null;
        try (Connection cn = pool.getConnection();
             PreparedStatement ps = cn.prepareStatement("select * from users where email = '?'")
        ) {
            ps.setString(1, email);
            try (ResultSet it = ps.executeQuery()) {
                if (it.next()) {
                    userEmail = new User(
                            it.getInt("id"),
                            it.getString("name"),
                            it.getString("password"),
                            it.getString("email")
                    );
                }
            }
        } catch (SQLException throwables) {
            LOG.error(throwables.getMessage(), throwables);
        }
        return userEmail;
    }
}
