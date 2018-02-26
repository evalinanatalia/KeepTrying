package com.example.widyabrigita.keeptrying;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by BRI on 2/26/2018.
 */

public class DialogReportHistory {

    private Context context;
    private Dialog mDialog;
    private EditText searchField;
    private TextView back;
    private ListView mList;
    private EditText fields;
    private EditText fields_hide;
    private int aksi;
    private String xxx= "xxx";

    private ProgressBar mProgress;
    private String id_prakarsa = "", type;
    private String [] value;
    private String ratas;
    double ratas_penjualan = 0.0, d_mutasi_kredit =0.0;
    private SimpleDateFormat sdf;

    Button btn_set;
    TextView from_date, to_date;

    Calendar myCalendar = Calendar.getInstance();

    public DialogReportHistory(Context mContext) {
        this.context = mContext;
    }

    /*public void callBack(OnCallback callback){
        this.callback = callback;
    }
*/
    public void showDialog() {
        if (mDialog == null) {
            mDialog = new Dialog(context, R.style.CustomDialogTheme);
        }

        mDialog.setContentView(R.layout.dialog_report_history);
        mDialog.setCancelable(true);
        mDialog.show();
        sdf = new SimpleDateFormat("dd-MM-yyyy");

        from_date = (TextView) mDialog.findViewById(R.id.from_date);
        to_date = (TextView) mDialog.findViewById(R.id.to_date);
        btn_set = (Button) mDialog.findViewById(R.id.btn_set);

        from_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(context, date_awal, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        to_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(context, date_akhir, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
            }
        });


    }
    DatePickerDialog.OnDateSetListener date_awal = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            from_date.setText(sdf.format(myCalendar.getTime()));
        }

    };

    DatePickerDialog.OnDateSetListener date_akhir = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            to_date.setText(sdf.format(myCalendar.getTime()));
        }

    };
}
