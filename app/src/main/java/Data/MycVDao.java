package Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MycVDao {
    @Query("SELECT * FROM mycv")
    LiveData<List<MyCv>>getAllMycvs();

    @Insert
    void insertCvs(MyCv myCv);
    @Delete
    void deleteMyCv(MyCv myCv);
    @Query("DELETE FROM mycv")
    void deleteAllCVS();

}
