package ca.camosun.lab7;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Converters.ConverterItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = Converters.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.name);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {

            final String name = mItem.name;
            Button button1 = (Button) rootView.findViewById(R.id.button);
            Button button2 = (Button) rootView.findViewById(R.id.button2);
            final TextView num1 = (TextView) rootView.findViewById(R.id.editText);
            final TextView num2 = (TextView) rootView.findViewById(R.id.editText2);
            button1.setText(mItem.leftConversion);
            button2.setText(mItem.rightConversion);

            button1.setOnClickListener( new View.OnClickListener() {

                public void onClick(View v) {

                    String initialVal = num1.getText().toString();
                    double firstNum = Double.parseDouble(initialVal);

                    switch(name) {
                        case "Temperature":
                            try {
                                num2.setText(String.format("%.2f", (firstNum - 32) / 1.80));
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "Length":
                            try {
                                num2.setText(String.format("%.2f", (firstNum / 3.2808)));
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "Area":
                            try {
                                num2.setText(String.format("%.2f", (firstNum * 2.4711)));
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "Weight":
                            try {
                                num2.setText(String.format("%.2f", (firstNum / 2.2046)));
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                }
            });

            button2.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {

                    String initialVal = num1.getText().toString();
                    double firstNum = Double.parseDouble(initialVal);

                    switch(name) {
                        case "Temperature":
                            try {
                                num2.setText(String.format("%.2f", (firstNum * 1.80) + 32.0));
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "Length":
                            try {
                                num2.setText(String.format("%.2f", (firstNum * 3.2808)));
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "Area":
                            try {
                                num2.setText(String.format("%.2f", (firstNum / 2.4711)));
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "Weight":
                            try {
                                num2.setText(String.format("%.2f", (firstNum * 2.2046)));
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                }
            });
        }

        return rootView;
    }
}