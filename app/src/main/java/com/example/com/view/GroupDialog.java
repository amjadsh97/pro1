package com.example.com.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GroupDialog extends AppCompatDialogFragment {

    private EditText editNameGroup;
    private GroupDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_group, null);
        builder.setView(view);
        builder.setTitle("Information input");
        builder.setMessage(" Enter Name the Group.");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String NameGroup = editNameGroup.getText().toString();
                listener.applyTexts(NameGroup);
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

             }
        });
        editNameGroup = view.findViewById(R.id.group_name);

        return builder.create();
        }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (GroupDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement GroupDialogListener");
        }
    }




    public interface GroupDialogListener {
        void applyTexts(String NameGroup);
    }


}
