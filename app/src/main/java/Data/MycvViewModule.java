package Data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MycvViewModule extends AndroidViewModel {
    public LiveData<List<MyCv>>mycvs;
    private MyCvDatabase myCvDatabase;

    public MycvViewModule(@NonNull Application application) {
        super(application);
        myCvDatabase=MyCvDatabase.getInstance(getApplication());
        mycvs=myCvDatabase.getMycvsDao().getAllMycvs();
    }

    public void insertMycVs(MyCv myCv){
       new InsertCvsTask().execute(myCv);
    }
    public void deleteMycvs(MyCv myCv){
        new DeleteCVS().execute(myCv);
    }
    public void deleteAllMycVs(){
        new DeleteAllCVS().execute();
    }

    public class InsertCvsTask extends AsyncTask<MyCv,Void,Void>{

        @Override
        protected Void doInBackground(MyCv... myCvs) {
            if(myCvs!=null&&myCvs.length>0){
               myCvDatabase.getMycvsDao().insertCvs(myCvs[0]);
            }
            return null;
        }
    }
    public class DeleteCVS extends AsyncTask<MyCv,Void,Void>{

        @Override
        protected Void doInBackground(MyCv... myCvs) {
            if(myCvs!=null&&myCvs.length>0){
                myCvDatabase.getMycvsDao().deleteMyCv(myCvs[0]);
            }
            return null;
        }
    }
    public class DeleteAllCVS extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            myCvDatabase.getMycvsDao().deleteAllCVS();
            return null;
        }
    }

    public LiveData<List<MyCv>> getMycvs() {
        return mycvs;
    }
}
