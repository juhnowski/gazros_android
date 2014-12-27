package net.phreebie.gazros;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

public class AllOrdersActivity extends ListActivity {

	String[] orders = {
			"1200 |Акимова - Есенина",
			"3600 |Волжская наб. - Кстово",
			"1100 |Московский - Аэропорт",
			"5200 |Мещерка - Щербинки",
			"1200 |Гордеевка-Автозавод",
			"2300 |В.печеры-Гнилицы",
			"2300 |Бор-Арзамас",
			"3300 |пр.Ленина-Гороховец",
			"2300 |Минина-Горького",
			"4300 |Рекшино-Бор",
			"6500 |Гнилицы-Речной вокзал",
			"2300 |ст.Варя-7й микр.",
			"2300 |пл.Ленина - пл.Лядова",
			"3300 |ул.Строителей - Навашино"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_orders);
//====================================================================================================================================		
		//setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, orders));
		ListView lstView = getListView();
		lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,orders));
		lstView.setTextFilterEnabled(true);
//====================================================================================================================================		
		
	}

	//====================================================================================================================================	
	public void onListItemClick(ListView parent, View v, int position, long id) {
		CheckedTextView item = (CheckedTextView) v; 
		if (item.isChecked()) {
			Toast.makeText(this, "Отказ от заказа:\n "+orders[position], Toast.LENGTH_SHORT).show();	
		} else {
			Toast.makeText(this, "Выбран заказ:\n "+orders[position], Toast.LENGTH_SHORT).show();
		}
			
	}
	//====================================================================================================================================
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.all_orders, menu);
		return true;
	}

}
