package com.example.calculator;

import android.app.Activity;
import android.content.OperationApplicationException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btn0;
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn7;
	private Button btn8;
	private Button btn9;
	private Button add;     //��
	private Button subtract;//��
	private Button multiply;//��
	private Button divide;//��
	private Button sqrt;//������
	private Button PI;
	private Button point;//��
	private Button clear;//ȫ�����
	private Button delete;//ɾ��
	private Button result;//����
	private EditText editText;//��ʾ��������
	private TextView textview;//��ʾ��ʽ
	private String operate="+";//������
	private double a=0.0,b=0.0;//������Ҫ�������
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//��ȡȫ����ťid
		btn0=(Button)findViewById(R.id.button0);//0,4,5,6,8,9,10,12,13,14
		btn1=(Button)findViewById(R.id.button4);
		btn2=(Button)findViewById(R.id.button5);
		btn3=(Button)findViewById(R.id.button6);
		btn4=(Button)findViewById(R.id.button8);
		btn5=(Button)findViewById(R.id.button9);
		btn6=(Button)findViewById(R.id.button10);
		btn7=(Button)findViewById(R.id.button12);
		btn8=(Button)findViewById(R.id.button13);
		btn9=(Button)findViewById(R.id.button14);
		add=(Button)findViewById(R.id.button7);
		subtract=(Button)findViewById(R.id.button11);
		multiply=(Button)findViewById(R.id.button15);
		divide=(Button)findViewById(R.id.button19);
		sqrt=(Button)findViewById(R.id.button16);
		PI=(Button)findViewById(R.id.button17);//δ������
		point=(Button)findViewById(R.id.button1);
		clear=(Button)findViewById(R.id.button2);
		result=(Button)findViewById(R.id.button3);
		delete=(Button)findViewById(R.id.button18);
		
		
		//Ϊ��ť��Ӽ�����
		btn0.setOnClickListener(listener);
		btn1.setOnClickListener(listener);
		btn2.setOnClickListener(listener);
		btn3.setOnClickListener(listener);
		btn4.setOnClickListener(listener);
		btn5.setOnClickListener(listener);
		btn6.setOnClickListener(listener);
		btn7.setOnClickListener(listener);
		btn8.setOnClickListener(listener);
		btn9.setOnClickListener(listener);
		add.setOnClickListener(listener);
		subtract.setOnClickListener(listener);
		multiply.setOnClickListener(listener);
		divide.setOnClickListener(listener);
		sqrt.setOnClickListener(listener);
		PI.setOnClickListener(listener);//�޴���
		point.setOnClickListener(listener);
		clear.setOnClickListener(listener);
		result.setOnClickListener(listener);
		delete.setOnClickListener(listener);
		
		
	}
	//���ò�ͬ��ť��id�ļ�����
	private OnClickListener listener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//��ȡ������
			editText=(EditText)findViewById(R.id.editText1);
			textview=(TextView)findViewById(R.id.textView1);
			String s=editText.getText().toString();//������װ��Ϊ�ַ���
			Button btn=(Button)v;
			String str=editText.getText().toString();
			try{
				switch (btn.getId()) {
				//��ť0,4,5,6,8,9,10,12,13,14Ϊ����
				case R.id.button0://0
					editText.setText(str + 0);
					str=editText.getText().toString();
					textview.setText(str);
					break;
					
				case R.id.button1://С����
					if (str.indexOf(".")!=-1) {
						//����Ѵ���С���㣬�����κβ���������ʾ����
						Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();;
					}
					else {
						if (str.equals("0")) {//С����ǰΪ0
							editText.setText(("0"+".").toString());
						}
						else if(str.equals(" ")){
							//С����ǰΪ�գ������κβ�������ʾ����
							Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();;
						}
						else{
							editText.setText(str+".");
						}
					}
					break;
				case R.id.button2://AC
					if (str.length()>0) {
						editText.setText(" ");//�����
						textview.setText(" ");
					}
					break;		
			//�жϷ��Ž��м���		
				case R.id.button3://=ȡ���
					if (operate=="+") {
						b=Double.parseDouble(str);
						textview.setText(a+operate+b+"=");
						editText.setText((a+b)+"");
					}
					else if (operate=="��") {
						b=Double.parseDouble(str);
						textview.setText(a+operate+b+"=");
						editText.setText((a-b)+"");
					}
					else if (operate=="��") {
						b=Double.parseDouble(str);
						textview.setText(a+operate+b+"=");
						editText.setText((a*b)+"");
					}
					else if (operate=="��") {
						b=Double.parseDouble(str);
						if (b==0) {
							editText.setText("");
							Toast.makeText(getApplicationContext(), "Error:��������Ϊ0", Toast.LENGTH_SHORT).show();;
						}
						else {
							textview.setText(a+operate+b+"=");
							editText.setText(a/b+"");
						}
					}
					
					break;
				case R.id.button4://1
                    editText.setText(str + 1);
                    str = editText.getText().toString();
                    textview.setText(str);                
					break;
				case R.id.button5://2
					editText.setText(str + 2);
					str=editText.getText().toString();
					textview.setText(str);
					break;	
				case R.id.button6://3
					 editText.setText(editText.getText().toString() + 3);
	                 textview.setText(str); 
					break;
				case R.id.button7://+
                    a = Double.parseDouble(str);
                    operate = "+";                    
                    textview.setText(a + operate);
                    editText.setText("");
					break;
				case R.id.button8:
					editText.setText(str + 4);
					str=editText.getText().toString();
					textview.setText(str);
					break;
				case R.id.button9:
					editText.setText(str + 5);
					str=editText.getText().toString();
					textview.setText(str);
					break;
				case R.id.button10:
					editText.setText(str + 6);
					str=editText.getText().toString();
					textview.setText(str);
					break;
				case R.id.button11://-
					operate="��";
					a=Double.parseDouble(str);
					editText.setText("");
					textview.setText(a+operate);
					break;
				case R.id.button12:
					editText.setText(str + 7);
					str=editText.getText().toString();
					textview.setText(str);
					break;
				case R.id.button13:
					editText.setText(str + 8);
					str=editText.getText().toString();
					textview.setText(str);
					break;	
				case R.id.button14:
					editText.setText(str + 9);
					str=editText.getText().toString();
					textview.setText(str);
					break;
				case R.id.button15://��
					a=Double.parseDouble(str);
					operate="��";
					editText.setText("");
					textview.setText(a+operate);
					break;
				case R.id.button16://����
					a=Double.parseDouble(str);
					if (a<0) {
						Toast.makeText(getApplicationContext(), "����û��ƽ����", Toast.LENGTH_LONG).show();;
					}
					else {
						editText.setText(Math.sqrt(a)+"");
						textview.setText("��"+a+"=");
					}
					break;
				case R.id.button17://PI
					////////////////////////////////////////////////////
					break;
				case R.id.button18://ɾ�������ַ�
					if (str.length()>0) {
						editText.setText(str.substring(0, str.length()-1));//��ԭ���ַ����Ļ���������ʾһ���ַ�
					}
					break;
				case R.id.button19://��
					a=Double.parseDouble(str);
					operate="��";
					editText.setText("");
					textview.setText(a+operate);
					break;

				default:
					break;
				}
				
			}catch(Exception e){
				
			}
			
		}
		
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
