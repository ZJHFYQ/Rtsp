
package com.example.zjh.rtspdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MediaPlayerDemo extends Activity {
	private Button mstreamvideo;
	private static final String MEDIA = "media";
	private static final int LOCAL_AUDIO = 1;
	private static final int STREAM_AUDIO = 2;
	private static final int RESOURCES_AUDIO = 3;
	private static final int LOCAL_VIDEO = 4;
	private static final int STREAM_VIDEO = 5;
	private static final int RESOURCES_VIDEO = 6;
	private static final int LOCAL_VIDEO_SURFACE = 7;

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.mediaplayer);
		mstreamvideo = (Button) findViewById(R.id.streamvideo);
		mstreamvideo.setOnClickListener(mStreamVideoListener);
	}
	private OnClickListener mStreamVideoListener = new OnClickListener() {
		public void onClick(View v) {
			TextView tv= (TextView) MediaPlayerDemo.this.findViewById(R.id.txt_ip);
			String address=tv.getText().toString().trim();
			if(address.length()<=0){
				Toast.makeText(MediaPlayerDemo.this, "流地址不能为空", Toast.LENGTH_SHORT).show();
				return ;
			}
			Intent intent = new Intent(MediaPlayerDemo.this, MediaPlayerDemo_Video.class);
			intent.putExtra(MEDIA, STREAM_VIDEO);
			intent.putExtra("address",address);
			startActivity(intent);
		}
	};
}
