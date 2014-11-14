package tnb.george.me.tasknotebook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tnb.george.me.tasknotebook.R;
import tnb.george.me.tasknotebook.bean.Task;
import tnb.george.me.tasknotebook.ui.TaskListActivity;
import tnb.george.me.tasknotebook.utils.UIUtils;

/**
 * Created by GeorgeZou on 2014/11/14.\
 *
 * @Description:<br/>
 * @Author:GeorgeZou(Zousongqi0213@gmail.com)<br/>
 * @Since:2014/11/14<br/>
 */
public class MyTaskListAdapter extends BaseAdapter {

    Context mContext;
    List<Task> mTask;

    public MyTaskListAdapter(Context context,List<Task> task) {
        super();
        mContext = context;
        mTask = task;
    }

    private int[] colors = new int[]{ 0xff626569, 0xff4f5257 };

    public View getView(final int position,View convertView,ViewGroup parent) {
        ImageView image = null;
        TextView title = null;
        TextView text = null;
        Button button = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.task_list_item, null
            );
            image = (ImageView) convertView.findViewById(R.id.array_image);
            title = (TextView) convertView.findViewById(R.id.array_title);
            text = (TextView) convertView.findViewById(R.id.array_text);
            button = (Button) convertView.findViewById(R.id.array_button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    UIUtils.showLong(mContext, "您点击的第" + position + "个按钮");

                }
            });
            int colorPos = position % colors.length;
            convertView.setBackgroundColor(colors[colorPos]);
            title.setText(mTask.get(position).getTaskTime().toString());
            text.setText(mTask.get(position).getTaskInfo());
            if(colorPos == 0)
                image.setImageResource(R.drawable.actionbar_add_icon);
            else
                image.setImageResource(R.drawable.actionbar_more_icon);

        }
        return convertView;
    }

    public int getCount() {
        return mTask.size();
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
}
