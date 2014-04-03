package com.fhooe.mc.interactivetechnologies.ucpisfun;

import java.util.Locale;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * This class provides a lateral navigation between sibling screens
 * with a horizontal finger gesture. 
 * It makes use of the ViewPager widget, available in the Support Library. With the ViewPager
 * layout widget each child view is a separate page in the layout.
 * @author ilias koletsis
 *
 */
public class MainActivity extends ActionBarActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 * When requested, this FragmentPageAdapter will return a new fragment,
	 * representing an object in the array of sibling pages.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	static ViewPager mViewPager;
	
	/**
	 * These buttons consist the navigation bar and are used for lateral navigation
	 * between different levels
	 */
	static Button navBtn1 = null;
	static Button navBtn2 = null;
	static Button navBtn3 = null;
	static Button navBtn4 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		
		//reference button
		Button navBtn1 = (Button) findViewById(R.id.navBtn1);
		Button navBtn2 = (Button) findViewById(R.id.navBtn2);
		Button navBtn3 = (Button) findViewById(R.id.navBtn3);
		Button navBtn4 = (Button) findViewById(R.id.navBtn4);

		navBtn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Log.e("ilias", "prev page: " + mViewPager.getCurrentItem());
				mViewPager.setCurrentItem(0);
			}
		});
		
		navBtn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Log.e("ilias", "prev page: " + mViewPager.getCurrentItem());
				mViewPager.setCurrentItem(1);
			}
		});
		
		navBtn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Log.e("ilias", "prev page: " + mViewPager.getCurrentItem());
				mViewPager.setCurrentItem(2);
			}
		});
		
		navBtn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Log.e("ilias", "prev page: " + mViewPager.getCurrentItem());
				mViewPager.setCurrentItem(3);
			}
		});
	
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

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

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class
			// below).
			return PlaceholderFragment.newInstance(position + 1);
		}

		@Override
		public int getCount() {
			// Show 4 total pages.
			return 4;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			case 4:
				return getString(R.string.title_section4).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment{
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,false);
			
			//reference textviews
			TextView title = (TextView) rootView.findViewById(R.id.section_title);
			TextView subTitle = (TextView) rootView.findViewById(R.id.section_subtitle);
			
			//reference layout
			RelativeLayout relLayout = (RelativeLayout) rootView.findViewById(R.id.fragment);
			
			//adjust fragment's content
			if(getArguments().getInt(ARG_SECTION_NUMBER) == 1){
//				navBtn1.setEnabled(false);
				title.setText("Level 1");
				subTitle.setText("Analysis");
				relLayout.setBackgroundColor(Color.RED);
			}else if(getArguments().getInt(ARG_SECTION_NUMBER) == 2){
//				navBtn2.setEnabled(false);
				title.setText("Level 2");
				subTitle.setText("Design");
				relLayout.setBackgroundColor(Color.CYAN);
			}else if(getArguments().getInt(ARG_SECTION_NUMBER) == 3){
//				navBtn3.setEnabled(false);
				title.setText("Level 3");
				subTitle.setText("Implementation");
				relLayout.setBackgroundColor(Color.GREEN);
			}else if(getArguments().getInt(ARG_SECTION_NUMBER) == 4){
//				navBtn4.setEnabled(false);
				title.setText("Level 4");
				subTitle.setText("Deployment");
				relLayout.setBackgroundColor(Color.YELLOW);
			}

			return rootView;
		}
		
		public void playButton(View v){
			Log.e("ilias", "play play play");
		}

	}
}
