package Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.base.mycvproject.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import Data.MyCv;

public class MyCvAdapters extends RecyclerView.Adapter<MyCvAdapters.MycvViewHolder> {
   public List<MyCv>myCvList;

    public MyCvAdapters(List<MyCv> myCvList) {
        this.myCvList = myCvList;
    }

    public List<MyCv> getMyCvList() {
        return myCvList;
    }

    public void setMyCvList(List<MyCv> myCvList) {
        this.myCvList = myCvList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MycvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.iteam_main_cv,parent,false);
        return new MycvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MycvViewHolder holder, int position) {
     MyCv myCv=myCvList.get(position);
       // Picasso.get().load(myCv.getUrlimage()).into(holder.imageViewposter);
        holder.textViewnameandlastname.setText(myCv.getNameandlastname());
        holder.textViewprofesion.setText(myCv.getProfession());
        holder.textViewpersoninfo.setText(myCv.getPersonalinformation());
        holder.textVieweducation.setText(myCv.getEducation());
        holder.textViewlanguages.setText(myCv.getLanguages());
        holder.textViewskills.setText(myCv.getSkills());
        holder.textViewexpirience.setText(myCv.getExpirience());
        holder.textViewawards.setText(myCv.getAwards());
    }

    @Override
    public int getItemCount() {
        return myCvList.size();
    }

    class MycvViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageViewposter;
        private TextView textViewnameandlastname;
        private TextView textViewprofesion;
        private TextView textViewpersoninfo;
        private TextView textViewexpirience;
        private TextView textVieweducation;
        private TextView textViewlanguages;
        private TextView textViewskills;
        private TextView textViewawards;
        public MycvViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewposter=itemView.findViewById(R.id.imageviewposter);
            textViewnameandlastname=itemView.findViewById(R.id.textViewNamelastname);
            textViewprofesion=itemView.findViewById(R.id.textView3);
            textViewpersoninfo=itemView.findViewById(R.id.textViewpersinalinformation);
            textViewexpirience=itemView.findViewById(R.id.textViewexperienc);
            textVieweducation=itemView.findViewById(R.id.textviewedu);
            textViewlanguages=itemView.findViewById(R.id.textViewlanguages);
            textViewskills=itemView.findViewById(R.id.textViewskils);
            textViewawards=itemView.findViewById(R.id.textViewawardik);
        }
    }
}
