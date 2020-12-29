package ir.allahverdi.roomexample.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ir.allahverdi.roomexample.entity.User;

@Dao
public interface UserDAO {
    @Insert
    void insert(User user);

    @Insert
    void insertAll(User... users);

    @Update
    void updateUser(User... users);

    @Query("SELECT * FROM user WHERE id LIKE :userId LIMIT 1")
    User findById(int userId);

    @Query("SELECT * FROM user WHERE phone_number LIKE :PhoneNumber LIMIT 1")
    User findByPhone(long PhoneNumber);

    @Query("SELECT * FROM user")
    List<User> getAll();

}
