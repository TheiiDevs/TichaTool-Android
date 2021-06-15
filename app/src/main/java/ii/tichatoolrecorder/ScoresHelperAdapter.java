package ii.tichatoolrecorder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ii.tichatoolrecorder.data.model.Scores;


public class ScoresHelperAdapter extends RecyclerView.Adapter {

    List <Scores> fetchdatalist1;

    public ScoresHelperAdapter(InputLayout inputLayout, List<Scores> fetchdatalist1) {
        this.fetchdatalist1 = fetchdatalist1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout, parent, false);
        ViewHolderClass viewHolder = new ViewHolderClass(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass viewHolder=(ViewHolderClass)holder;

        Scores fetchData1 = fetchdatalist1.get(position);
        viewHolder.FirstScore_textview.setText(fetchData1.getFirstScore());

        viewHolder.SecondScore_textview.setText(fetchData1.getSecondScore());
        viewHolder.ThirdScore_textview.setText(fetchData1.getThirdScore());
        viewHolder.FourthScore_textview.setText(fetchData1.getFourthScore());

    }

    @Override
    public int getItemCount() {
        return fetchdatalist1.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder{
        TextView  SecondScore_textview, FirstScore_textview, ThirdScore_textview, FourthScore_textview, ExamScore_textview, caScore_textview, TotalScore_textview;


        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);

            SecondScore_textview = itemView.findViewById(R.id.secondscore_textview);
            FirstScore_textview = itemView.findViewById(R.id.firstscore_textview);
            ThirdScore_textview = itemView.findViewById(R.id.thirdscore_textview);
            FourthScore_textview = itemView.findViewById(R.id.fourthscore_textview);
            ExamScore_textview= itemView.findViewById(R.id.examscore_textview);
            caScore_textview = itemView.findViewById(R.id.cascore_textview);
            TotalScore_textview= itemView.findViewById(R.id.totalscore_textview);
        }
    }
}
