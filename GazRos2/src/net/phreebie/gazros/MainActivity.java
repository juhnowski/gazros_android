package net.phreebie.gazros;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Intent iLogin;
    
    private static final String site_url="http://gruzvezet52.ru";
    private Intent iSite;

    private static final String update_url="https://play.google.com/store";
    private Intent iUpdate;
    
    private Intent iNewOrder;
    private Intent iCancelOrders;
    private Intent iMyOrders;
    private Intent iAllOrders;
    private Intent iNewOrders;
    private Intent iSettings;
    
    public String token = new String();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Settings
		iSettings = new Intent(Intent.ACTION_VIEW);
		iSettings.setAction("net.phreebie.gazros.SettingsActivity");
        final Button btnSettings = (Button) findViewById(R.id.buttonSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(iSettings);
			}
		});	
        
		//New Orders
		iNewOrders = new Intent(Intent.ACTION_VIEW);
		iNewOrders.setAction("net.phreebie.gazros.NewOrdersActivity");
        final Button btnNewOrders = (Button) findViewById(R.id.buttonNewOrders);
        btnNewOrders.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(iNewOrders);
			}
		});	
		
		//All Orders
		iAllOrders = new Intent(Intent.ACTION_VIEW);
		iAllOrders.setAction("net.phreebie.gazros.AllOrdersActivity");
        final Button btnAllOrders = (Button) findViewById(R.id.buttonAllOrders);
        btnAllOrders.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(iAllOrders);
			}
		});	
		
		//My Orders
		iMyOrders = new Intent(Intent.ACTION_VIEW);
		iMyOrders.setAction("net.phreebie.gazros.MyOrdersActivity");
        final Button btnMyOrders = (Button) findViewById(R.id.buttonMyOrders);
        btnMyOrders.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(iMyOrders);
			}
		});	
		
		//New Order
		iNewOrder = new Intent(Intent.ACTION_VIEW);
		iNewOrder.setAction("net.phreebie.gazros.NewOrderActivity");
        final Button btnNewOrder = (Button) findViewById(R.id.buttonNewOrder);
        btnNewOrder.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(iNewOrder);
			}
		});	
		
		//Cancel Order
		iCancelOrders = new Intent(Intent.ACTION_VIEW);
		iCancelOrders.setAction("net.phreebie.gazros.CancelOrderActivity");
        final Button btnCancel = (Button) findViewById(R.id.buttonCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(iCancelOrders);
			}
		});		
		
        //Get Update
        iUpdate = new Intent(Intent.ACTION_VIEW);
        iUpdate.setData(Uri.parse(update_url));
        final Button btnUpdate = (Button) findViewById(R.id.buttonUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(iUpdate);
			}
		});		
		
	    //Show site
        iSite = new Intent(Intent.ACTION_VIEW);
        iSite.setData(Uri.parse(site_url));
        final Button btnSite = (Button) findViewById(R.id.buttonSite);
        btnSite.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(iSite);
			}
		});
        
        //Registration form
        iLogin = new Intent();
        iLogin.setAction("net.phreebie.gazros.LoginActivity");
        
        if(token.length()==0) {
        	token = new String("1234567890");
        	startActivity(iLogin);
        } else {
        	startActivity(iAllOrders);
        }
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
