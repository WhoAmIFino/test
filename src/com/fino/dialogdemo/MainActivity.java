package com.fino.dialogdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterFactory;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {
String []single_list={"男","女生","女博士","程序员"};
String []multi_list={"篮球","足球","乒乓球","排球"};
String []item_list={"项目经理","策划","测试","美工"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initEvent();
	}
	
	private void initEvent(){
	findViewById(R.id.dialog_bt1).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			showDialog1();
		}
	});
findViewById(R.id.dialog_bt2).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			showDialog2();
		}
	});	
findViewById(R.id.dialog_bt3).setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		showDialog3();
	}
});
findViewById(R.id.dialog_bt4).setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		showDialog4();
	}
});	
findViewById(R.id.dialog_bt5).setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		showDialog5();
	}
});	


	}
private void showDialog1(){
	AlertDialog.Builder builder=new AlertDialog.Builder(this);
	builder.setTitle("确认对话框");
	builder.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
	builder.setMessage("是否确认退出");
	builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			//Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_LONG).show();
			System.exit(0);
			
		}
	});
	builder.setNegativeButton("取消 ", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "点击了取消按钮", Toast.LENGTH_LONG).show();
			
		}
	});
	AlertDialog dialog=builder.create();
	dialog.show();
	
}

private void showDialog2(){
	AlertDialog.Builder builder=new AlertDialog.Builder(this);
	builder.setTitle("单选按钮对话框");
	builder.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
	builder.setSingleChoiceItems(single_list, 0, new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			String str=single_list[which];
			Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
		}
	});
	
	AlertDialog dialog=builder.create();
	dialog.show();
	
}

private void showDialog3(){
	AlertDialog.Builder builder=new AlertDialog.Builder(this);
	builder.setTitle("多选按钮对话框");
	builder.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
	builder.setMultiChoiceItems(multi_list, null, new   DialogInterface.OnMultiChoiceClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which, boolean isChecked) {
			// TODO Auto-generated method stub
			if(isChecked){
				
				Toast.makeText(MainActivity.this,"我喜欢上了:"+ multi_list[which]+"!!!!!!", Toast.LENGTH_LONG).show();
				
			}
		}
	});
	
	AlertDialog dialog=builder.create();
	dialog.show();
	
}
private void showDialog4(){
	AlertDialog.Builder builder=new AlertDialog.Builder(this);
	builder.setTitle("列表按钮对话框");
	builder.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
	builder.setItems(item_list, new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
      Toast.makeText(MainActivity.this,"我动了:"+ item_list[which]+"!!!!!!", Toast.LENGTH_LONG).show();	
		}
	} );
	
	AlertDialog dialog=builder.create();
	dialog.show();
	
}
private void showDialog5(){
	LayoutInflater innflater=LayoutInflater.from(this);
	View view=innflater.inflate(R.layout.dailog_layout, null);

	
	
	
	AlertDialog.Builder builder=new AlertDialog.Builder(this);
	builder.setTitle("列表按钮对话框");
	builder.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
	builder.setView(view);	builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_LONG).show();
//			System.exit(0);
			
		}
	});
	
	view.findViewById(R.id.bt).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "已提交", Toast.LENGTH_LONG).show();
	
		}
	});
	
	
	final AlertDialog dialog=builder.create();
	dialog.show();
view.findViewById(R.id.bt).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "已提交", Toast.LENGTH_LONG).show();
	     dialog.dismiss();//关闭或者隐藏
		}
	});
	
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
