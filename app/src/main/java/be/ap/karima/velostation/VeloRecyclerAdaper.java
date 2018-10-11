package be.ap.karima.velostation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class VeloRecyclerAdaper extends RecyclerView.Adapter<VeloRecyclerAdaper.ViewHolder> {

    private final Context context;
    private final LayoutInflater layoutInflater;
    private final List<Station> stationList;

    public VeloRecyclerAdaper(Context context, List<Station> stationList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.stationList = stationList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.velo, parent, false);
        return new ViewHolder(itemView); //de nested class wordt hier geinitialiseerd en in de VeloRecyclerAdapter verder gebruikt
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Station velostation = stationList.get(position);
        holder.currentPosition = position;
        holder.myNaamTextView.setText(velostation.getName());

    }


    @Override
    public int getItemCount() {
        return stationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView myNaamTextView;
        public int currentPosition;

        public ViewHolder(View itemView) {
            super(itemView);
            myNaamTextView = (TextView) itemView.findViewById(R.id.naam_textview);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, VeloMapActivity.class);
                    intent.putExtra("pos", ""+currentPosition);
                    context.startActivity(intent);
                }
            });

        }


    }
}
