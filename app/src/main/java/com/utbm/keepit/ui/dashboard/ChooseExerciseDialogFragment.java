//package com.utbm.keepit.ui.dashboard;
//
//import android.app.Dialog;
//
//import androidx.fragment.app.DialogFragment;
//
//
//public class ChooseExerciseDialogFragment extends DialogFragment {
//
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        selectedItems = new ArrayList();  // Where we track the selected items
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        // Set the dialog title
//        builder.setTitle(R.string.pick_toppings)
//                // Specify the list array, the items to be selected by default (null for none),
//                // and the listener through which to receive callbacks when items are selected
//                .setMultiChoiceItems(R.array.toppings, null,
//                        new DialogInterface.OnMultiChoiceClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which,
//                                                boolean isChecked) {
//                                if (isChecked) {
//                                    // If the user checked the item, add it to the selected items
//                                    selectedItems.add(which);
//                                } else if (selectedItems.contains(which)) {
//                                    // Else, if the item is already in the array, remove it
//                                    selectedItems.remove(Integer.valueOf(which));
//                                }
//                            }
//                        })
//                // Set the action buttons
//                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        // User clicked OK, so save the selectedItems results somewhere
//                        // or return them to the component that opened the dialog
//                   ...
//                    }
//                })
//                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                   ...
//                    }
//                });
//
//        return builder.create();
//    }
//}