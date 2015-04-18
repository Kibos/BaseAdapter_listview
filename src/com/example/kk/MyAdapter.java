package com.example.kk;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends BaseAdapter {
	Context _context;
	String[] _texts;
	int[] _images;
	
	public  MyAdapter(Context mContext,String[] mTexts,int[] mImages) {
		// TODO Auto-generated constructor stub
		_context=mContext;
		_texts=mTexts;
		_images=mImages;
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return _images.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return _texts[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		final ViewHolder holder;
		Log.i("TAG","->>"+" position="+position+" "+convertView);
		
		if(convertView==null){
			LayoutInflater inflater = LayoutInflater.from(_context);
			convertView = inflater.inflate(R.layout.listviewxml, null);
			holder = new ViewHolder();
			holder.imageView=(ImageView)convertView.findViewById(R.id.imageView1);
			holder.textView=(TextView)convertView.findViewById(R.id.textView1);
			holder.editText=(EditText)convertView.findViewById(R.id.editText1);
			holder.viewBtn=(Button)convertView.findViewById(R.id.button1);
			convertView.setTag(holder);
		}
		else{
			holder=(ViewHolder)convertView.getTag();
		}
		
		//ImageView imageView=(ImageView)view.findViewById(R.id.imageView1);
		//TextView textView = (TextView)view.findViewById(R.id.textView1);
		//imageView.setImageResource(_images[position]);
		//textView.setText(_texts[position]);
		holder.imageView.setImageResource(_images[position]);
		holder.textView.setText(_texts[position]);
		
		final int myPosition =position;
		holder.viewBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				String textString = holder.editText.getText().toString();
				Log.d("Button   :", textString);
				System.out.println("  tr:" + textString);
				if (textString != "" && textString.length() != 0
						&& textString != null) {
					Toast.makeText(_context, "success ", Toast.LENGTH_SHORT)
							.show();
					
					
					holder.textView.setText(holder.editText.getText());
					_texts[myPosition]=textString;
					holder.editText.setText("");
					

				} else {
					Toast.makeText(_context, "文本不能为空！ ", Toast.LENGTH_SHORT)
							.show();
				}
			
				
				
			}
		});
		return convertView;
	}
	public class ViewHolder{
		public ImageView imageView;
		public EditText editText;
		public TextView textView;
		public Button viewBtn;
		
	}
}
