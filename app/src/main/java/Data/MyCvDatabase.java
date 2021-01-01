package Data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.locks.Lock;
@Database(entities = {MyCv.class},version = 2,exportSchema = false)
public abstract class MyCvDatabase extends RoomDatabase {
    private static MyCvDatabase myCvDatabase;
    public static final Object LOCK=new Object();
    private static final String DATA_BASE="mycv.db";

    public static MyCvDatabase getInstance(Context context){
        synchronized (LOCK){
            if(myCvDatabase==null){
                myCvDatabase= Room.databaseBuilder
                        (context,MyCvDatabase.class,DATA_BASE)
                        .fallbackToDestructiveMigration().build();
            }
        }
        return myCvDatabase;
    }
    public abstract MycVDao getMycvsDao();
}
