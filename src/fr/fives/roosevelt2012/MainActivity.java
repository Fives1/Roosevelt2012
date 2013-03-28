package fr.fives.roosevelt2012;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/*
 * Important :
 * - in a HTML File, we must replace "%" by "&#37;" otherwise on runtime : "Web page not available"
 */

public class MainActivity extends Activity {


	private Button logoButton = null;
	private Button languageFlag = null;
	private Button jeSigneButton = null;
	private Button etApresButton = null;
	private Button jeSigne2Button = null;
	private Button etApres2Button = null;
	private Button zoomIn;
	private Button zoomOut;

	private TextView titleTV = null;
	private TextView countOfSignaturesTV = null;
	private TextView countOfSignatures2TV = null;
	private Button stephaneHesselVideoButton = null;
	private Button floatingButton = null;
	private TextView nousAvonsDecideDAgir_TitreTV = null;
	private TextView nousAvonsDecideDAgir_CorpsTV = null;
	private TextView nousSouhaitonsContribuerTV = null;
	private TextView direLExtremeGraviteTV = null;
	private ImageView direLExtremeGraviteIV = null;
	private TextView troisChantierTV = null;
	private TextView quinzeReformesTV = null;
	private TextView mesMentionsTV = null;

	int groupOfButtonsOpened = 1;
	private Button eviterLEffondrement = null;
	private Button contreLeChomage = null;
	private Button construireUneEuropeDemocratique = null;

	private Button reformButton[] = new Button[15];
	private Button mesMentionsButton = null;

	// To trace and to know if there is a move gesture :
	int xPtr = -1;
	int yPtr = -1;
	boolean inActionMove = false;
	int xPtrPrevForMove = -1;
	int yPtrPrevForMove = -1;

	// Menu :
	private int menuSchemasId = Menu.FIRST;
	private int menuJeSigne2Id = Menu.FIRST + 1;
	private int menuLeCollectifId = Menu.FIRST + 2;
	private int menuLaVideoId = Menu.FIRST + 3;
	private int menuLesGroupesLocauxId = Menu.FIRST + 4;
	private int menuActualitesId = Menu.FIRST + 5;
	private int menuGroup1Id = 1;
	private int menuGroup2Id = 2;
	private int menuGroup3Id = 3;
	private int menuGroup4Id = 4;
	private int menuGroup5Id = 5;
	private int menuGroup6Id = 6;

	@SuppressLint("ParserError")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Valorize main values :
		VG.languageChoiced = VG.language.FRENCH;
		VG.textSizeOfTitleInButton = 20;
		VG.textSizeOfBodyInButton = 14;
		Utils.valorizeMyMentions(VG.languageChoiced);
		Utils.chargReformTitles(VG.languageChoiced);
		Utils.valorizeNousAvonsDecideDAgirEntete(VG.languageChoiced);
		Utils.valorizeNousAvonsDecideDAgirCorps(MainActivity.this,
				VG.languageChoiced);
		Utils.valorizeTitle(VG.languageChoiced);
		Utils.valorizeCountOfSignatures(VG.languageChoiced);
		Utils.valorizeStephaneHessel(VG.languageChoiced);
		Utils.valorizeNousSouhaitonsContribuer(VG.languageChoiced);
		Utils.valorizeDireLEctremeGravite(MainActivity.this, VG.languageChoiced);
		Utils.valorizeTroisChantiers(VG.languageChoiced);
		Utils.valorize15Reforms(VG.languageChoiced);

		// Change title of the page :
		setTitle("Roosevelt 2012 - Unofficial");
		setTitleColor(VG.COLOR_BLACK);
		// Change backgound color of the title :
		View titleView = getWindow().findViewById(android.R.id.title);
		if (titleView != null) {
			ViewParent parent = titleView.getParent();
			if (parent != null && (parent instanceof View)) {
				View parentView = (View) parent;
				parentView.setBackgroundColor(VG.COLOR_YELLOW_WHITE);
			}
		}

		// Change color of the background of the linearlayout:
		View someView = findViewById(R.id.linearlayout);
		View root = someView.getRootView();
		root.setBackgroundColor(VG.COLOR_YELLOW_WHITE);

		// Valorize texts with the langage choozed :
		Utils.valorizeSchemasNamesAndUrlsAndLegends(VG.languageChoiced);

		logoButton = (Button) this.findViewById(R.id.logo);
		logoButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Utils.execInternetBrowser(MainActivity.this,
						VG.insternetSiteUrl);
			}
		});

		languageFlag = (Button) this.findViewById(R.id.language_flag);
		languageFlag.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (VG.languageChoiced == VG.language.FRENCH) {
					VG.languageChoiced = VG.language.ENGLISH;
					languageFlag.setBackgroundResource(R.drawable.english_flag);
				} else if (VG.languageChoiced == VG.language.ENGLISH) {
					VG.languageChoiced = VG.language.ITALIAN;
					languageFlag.setBackgroundResource(R.drawable.italian_flag);
				} else if (VG.languageChoiced == VG.language.ITALIAN) {
					VG.languageChoiced = VG.language.SPANISH;
					languageFlag.setBackgroundResource(R.drawable.spanish_flag);
				} else if (VG.languageChoiced == VG.language.SPANISH) {
					VG.languageChoiced = VG.language.GERMANY;
					languageFlag.setBackgroundResource(R.drawable.germany_flag);
				} else {
					VG.languageChoiced = VG.language.FRENCH;
					languageFlag.setBackgroundResource(R.drawable.french_flag);
				}
				// Recharge texts into values ÷
				Utils.chargReformTitles(VG.languageChoiced);
				// Re-valorize texts on pages :
				languageFlag.invalidate();
				jeSigneButton.setText(VG.jeSigne);
				jeSigneButton.invalidate();
				etApresButton.setText(VG.etApres);
				etApresButton.invalidate();
				jeSigne2Button.setText(VG.jeSigne);
				jeSigne2Button.invalidate();
				etApres2Button.setText(VG.etApres);
				etApres2Button.invalidate();
				eviterLEffondrement.setText(VG.REFORMS_RUBRICS.get(0));
				contreLeChomage.setText(VG.REFORMS_RUBRICS.get(1));
				construireUneEuropeDemocratique.setText(VG.REFORMS_RUBRICS
						.get(2));
				for (int i = 0; i < 15; i++) {
					reformButton[i].setText(VG.REFORMS_TITLE.get(i + 1).title);
					reformButton[i].invalidate();
				}
				Utils.valorizeTitle(VG.languageChoiced);
				titleTV.setText(Html.fromHtml(VG.title));
				titleTV.invalidate();
				Utils.valorizeCountOfSignatures(VG.languageChoiced);
				countOfSignaturesTV.setText(Html.fromHtml(VG.countOfSignatures));
				countOfSignaturesTV.invalidate();
				countOfSignatures2TV.setText(Html.fromHtml(VG.countOfSignatures));
				countOfSignatures2TV.invalidate();
				Utils.valorizeStephaneHessel(VG.languageChoiced);
				stephaneHesselVideoButton.setText(VG.stephaneHessel_text);
				stephaneHesselVideoButton.invalidate();
				floatingButton.setText("Signez dès maintenant l'appel pour une vraie séparation des banques d'affaires et des banques de dépôt ! - Lié à Proposition 7");
				floatingButton.invalidate();
				Utils.valorizeNousAvonsDecideDAgirEntete(VG.languageChoiced);
				nousAvonsDecideDAgir_TitreTV.setText(Html
						.fromHtml(VG.nousAvonsDecideDAgir_Titre));
				nousAvonsDecideDAgir_TitreTV.invalidate();
				Utils.valorizeNousAvonsDecideDAgirCorps(MainActivity.this,
						VG.languageChoiced);
				nousAvonsDecideDAgir_CorpsTV.setText(Html
						.fromHtml(VG.nousAvonsDecideDAgir_Corps));
				nousAvonsDecideDAgir_CorpsTV.invalidate();
				Utils.valorizeNousSouhaitonsContribuer(VG.languageChoiced);
				nousSouhaitonsContribuerTV.setText(Html
						.fromHtml(VG.nousSouhaitonsContribuer));
				nousSouhaitonsContribuerTV.invalidate();
				Utils.valorizeDireLEctremeGravite(MainActivity.this,
						VG.languageChoiced);
				direLExtremeGraviteTV.setText(Html
						.fromHtml(VG.direLExtremeGravite));
				direLExtremeGraviteTV.invalidate();
				if (VG.languageChoiced == VG.language.ENGLISH) {
					direLExtremeGraviteIV
							.setImageResource(R.drawable.english_dire_l_extreme_gravite);
				} else if (VG.languageChoiced == VG.language.ITALIAN) {
					direLExtremeGraviteIV
							.setImageResource(R.drawable.italy_dire_l_extreme_gravite);
				} else if (VG.languageChoiced == VG.language.SPANISH) {
					direLExtremeGraviteIV
							.setImageResource(R.drawable.spanish_dire_l_extreme_gravite);
				} else if (VG.languageChoiced == VG.language.GERMANY) {
					// direLExtremeGraviteIV.setImageResource(R.drawable.germany_dire_l_extreme_gravite);
				} else {
					direLExtremeGraviteIV
							.setImageResource(R.drawable.dire_l_extreme_gravite);
				}
				direLExtremeGraviteIV.invalidate();
				Utils.valorizeTroisChantiers(VG.languageChoiced);
				troisChantierTV.setText(Html.fromHtml(VG.troisChantier));
				troisChantierTV.invalidate();
				Utils.valorize15Reforms(VG.languageChoiced);
				quinzeReformesTV.setText(Html.fromHtml(VG.quinzeReformes));
				quinzeReformesTV.invalidate();
				Utils.valorizeMyMentions(VG.languageChoiced);
				mesMentionsTV.setText(VG.mesMentions_information);
				mesMentionsTV.invalidate();
				mesMentionsButton.setText(VG.mesMentions_textButton);
				mesMentionsTV.invalidate();
				Utils.valorizeSchemasNamesAndUrlsAndLegends(VG.languageChoiced);
			}
		});

		jeSigneButton = (Button) this
				.findViewById(R.id.je_signe);
		jeSigneButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Utils.execInternetBrowser(MainActivity.this,
						VG.jeSigneUrl);
			}
		});
		jeSigneButton.setTextColor(VG.COLOR_BLACK);

		etApresButton = (Button) this
				.findViewById(R.id.et_apres);
		etApresButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Utils.execInternetBrowser(MainActivity.this,
						VG.etApresUrl);
			}
		});
		etApresButton.setTextColor(VG.COLOR_BLACK);

		zoomOut = (Button) this.findViewById(R.id.zoomOut2);
		zoomOut.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					zoomTextSize(-2);
			}
		});
		zoomIn = (Button) this.findViewById(R.id.zoomIn2);
		zoomIn.setVisibility(View.VISIBLE);
		zoomIn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				zoomTextSize(+2);
			}
		});

//		ImageView mosaiqueIV = (ImageView) this.findViewById(R.id.mosaique);
//		mosaiqueIV.setBackgroundColor(VG.COLOR_BROWN);
		titleTV = (TextView) this.findViewById(R.id.title);
		titleTV.setBackgroundColor(VG.COLOR_YELLOW_WHITE);
		titleTV.setTextColor(VG.COLOR_BROWN);
		ImageView pen = (ImageView) this.findViewById(R.id.pen);
		countOfSignaturesTV = (TextView) this.findViewById(R.id.signatures);
		countOfSignaturesTV.setBackgroundColor(VG.COLOR_YELLOW_WHITE);
		countOfSignaturesTV.setTextColor(VG.COLOR_BROWN);
		nousAvonsDecideDAgir_TitreTV = (TextView) this
				.findViewById(R.id.nous_avons_decide_dagir_titre);
		nousAvonsDecideDAgir_TitreTV.setBackgroundColor(VG.COLOR_BROWN);
		nousAvonsDecideDAgir_TitreTV.setTextColor(VG.COLOR_ORANGE);
		nousAvonsDecideDAgir_TitreTV.setTextSize(VG.textSizeOfTitleInButton);
		nousAvonsDecideDAgir_CorpsTV = (TextView) this
				.findViewById(R.id.nous_avons_decide_dagir_corps);
		nousAvonsDecideDAgir_CorpsTV.setBackgroundColor(VG.COLOR_BROWN);
		nousAvonsDecideDAgir_CorpsTV.setTextColor(VG.COLOR_YELLOW);
		nousAvonsDecideDAgir_CorpsTV.setTextSize(VG.textSizeOfBodyInButton);
		nousAvonsDecideDAgir_CorpsTV.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Utils.execInternetBrowser(MainActivity.this,
						"http://docs.google.com/viewer?url="
								+ VG.nousAvonsDecideDAgir_Url);
			}
		});
		nousSouhaitonsContribuerTV = (TextView) this
				.findViewById(R.id.nous_souhaitons_contribuer);
		nousSouhaitonsContribuerTV.setBackgroundColor(VG.COLOR_YELLOW_WHITE);
		nousSouhaitonsContribuerTV.setTextColor(VG.COLOR_BLACK);
		nousSouhaitonsContribuerTV.setTextSize(VG.textSizeOfBodyInButton);
		direLExtremeGraviteTV = (TextView) this
				.findViewById(R.id.dire_l_extreme_gravite_texte);
		direLExtremeGraviteTV.setBackgroundColor(VG.COLOR_ORANGE);
		direLExtremeGraviteTV.setTextColor(VG.COLOR_WHITE);
		direLExtremeGraviteTV.setTextSize(VG.textSizeOfBodyInButton);
		direLExtremeGraviteTV.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Utils.execInternetBrowser(MainActivity.this,
						"http://docs.google.com/viewer?url="
								+ VG.direLExtremeGravite_Url);
			}
		});
		direLExtremeGraviteIV = (ImageView) this
				.findViewById(R.id.dire_l_extreme_gravite_image);
		direLExtremeGraviteIV.setBackgroundColor(VG.COLOR_ORANGE);
		troisChantierTV = (TextView) this.findViewById(R.id.trois_chantiers);
		troisChantierTV.setBackgroundColor(VG.COLOR_YELLOW_WHITE);
		troisChantierTV.setTextColor(VG.COLOR_BROWN);
		troisChantierTV.setTextSize(VG.textSizeOfTitleInButton);
		quinzeReformesTV = (TextView) this.findViewById(R.id.quinze_reformes);
		quinzeReformesTV.setBackgroundColor(VG.COLOR_YELLOW_WHITE);
		quinzeReformesTV.setTextColor(VG.COLOR_ORANGE);
		quinzeReformesTV.setTextSize(VG.textSizeOfTitleInButton);
		mesMentionsTV = (TextView) this.findViewById(R.id.mes_mentions_text);
		mesMentionsTV.setBackgroundColor(VG.COLOR_YELLOW_WHITE);
		mesMentionsTV.setTextColor(VG.COLOR_BLACK);
		mesMentionsTV.setText(VG.mesMentions_information);
		// informationsTV = (TextView) this.findViewById(R.id.informations);
		eviterLEffondrement = (Button) this
				.findViewById(R.id.eviterLEffondrement);
		eviterLEffondrement.setClickable(false);
		eviterLEffondrement.setTextColor(VG.COLOR_BLACK);
		eviterLEffondrement.setTextSize(VG.textSizeOfTitleInButton);
		eviterLEffondrement.setBackgroundColor(VG.COLOR_GREEN_BLUE);
		contreLeChomage = (Button) this.findViewById(R.id.contreLeChomage);
		contreLeChomage.setClickable(true);
		contreLeChomage.setTextColor(VG.COLOR_WHITE);
		contreLeChomage.setTextSize(VG.textSizeOfTitleInButton);
		contreLeChomage.setBackgroundColor(VG.COLOR_GREEN_BLUE);
		construireUneEuropeDemocratique = (Button) this
				.findViewById(R.id.construireEurope);
		construireUneEuropeDemocratique.setClickable(true);
		construireUneEuropeDemocratique.setTextColor(VG.COLOR_WHITE);
		construireUneEuropeDemocratique.setTextSize(VG.textSizeOfTitleInButton);
		construireUneEuropeDemocratique.setBackgroundColor(VG.COLOR_GREEN_BLUE);

		// Create all buttons for reforms :
		for (int i = 0; i < 15; i++) {
			if (i == 0) {
				reformButton[i] = (Button) this.findViewById(R.id.reforme01);
			} else if (i == 1) {
				reformButton[i] = (Button) this.findViewById(R.id.reforme02);
			} else if (i == 2) {
				reformButton[i] = (Button) this.findViewById(R.id.reforme03);
			} else if (i == 3) {
				reformButton[i] = (Button) this.findViewById(R.id.reforme04);
			} else if (i == 4) {
				reformButton[i] = (Button) this.findViewById(R.id.reforme05);
			} else if (i == 5) {
				reformButton[i] = (Button) this.findViewById(R.id.reforme06);
			} else if (i == 6) {
				reformButton[i] = (Button) this.findViewById(R.id.reforme07);
			} else if (i == 7) {
				reformButton[i] = (Button) this.findViewById(R.id.reforme08);
			} else if (i == 8) {
				reformButton[i] = (Button) this.findViewById(R.id.reforme09);
			} else if (i == 9) {
				reformButton[i] = (Button) this.findViewById(R.id.reforme10);
			} else if (i == 10) {
				reformButton[i] = (Button) this.findViewById(R.id.reforme11);
			} else if (i == 11) {
				reformButton[i] = (Button) this.findViewById(R.id.reforme12);
			} else if (i == 12) {
				reformButton[i] = (Button) this.findViewById(R.id.reforme13);
			} else if (i == 13) {
				reformButton[i] = (Button) this.findViewById(R.id.reforme14);
			} else if (i == 14) {
				reformButton[i] = (Button) this.findViewById(R.id.reforme15);
			}
			reformButton[i].setTextColor(VG.COLOR_ORANGE);
			reformButton[i].setTextSize(VG.textSizeOfBodyInButton);
		}

		// Valorize values :
		titleTV.invalidate();
		Utils.valorizeTitle(VG.languageChoiced);
		titleTV.setText(Html.fromHtml(VG.title));
		Utils.valorizeCountOfSignatures(VG.languageChoiced);
		countOfSignaturesTV.setText(Html.fromHtml(VG.countOfSignatures));
		Utils.valorizeStephaneHessel(VG.languageChoiced);
		stephaneHesselVideoButton = (Button) this
				.findViewById(R.id.stephane_hessel_video);
		stephaneHesselVideoButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Utils.execInternetBrowser(MainActivity.this,
						"http://www.dailymotion.com/video/xqw9u1_appel-de-stephane-hessel-roosevelt-2012_news?start=1#.UTOYKRwWVok");
			}
		});
		stephaneHesselVideoButton.setTextColor(VG.COLOR_BLACK);
//		stephaneHesselVideoButton.setBackgroundColor(VG.COLOR_ORANGE);
		floatingButton = (Button) this
				.findViewById(R.id.floating_button);
		floatingButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Utils.execInternetBrowser(MainActivity.this,
						"http://www.monadversairecestlafinance.fr/");
			}
		});
		floatingButton.setTextColor(VG.COLOR_RED);
//		floatingButton.setBackgroundColor(VG.COLOR_ORANGE);
		Utils.valorizeNousAvonsDecideDAgirEntete(VG.languageChoiced);
		nousAvonsDecideDAgir_TitreTV.setText(Html
				.fromHtml(VG.nousAvonsDecideDAgir_Titre));
		Utils.valorizeNousAvonsDecideDAgirCorps(MainActivity.this,
				VG.languageChoiced);
		nousAvonsDecideDAgir_CorpsTV.setText(Html
				.fromHtml(VG.nousAvonsDecideDAgir_Corps));
		Utils.valorizeNousSouhaitonsContribuer(VG.languageChoiced);
		nousSouhaitonsContribuerTV.setText(Html
				.fromHtml(VG.nousSouhaitonsContribuer));
		Utils.valorizeDireLEctremeGravite(MainActivity.this, VG.languageChoiced);
		direLExtremeGraviteTV.setText(Html.fromHtml(VG.direLExtremeGravite));
		Utils.valorizeTroisChantiers(VG.languageChoiced);
		troisChantierTV.setText(Html.fromHtml(VG.troisChantier));
		Utils.valorize15Reforms(VG.languageChoiced);
		quinzeReformesTV.setText(Html.fromHtml(VG.quinzeReformes));
		eviterLEffondrement.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (groupOfButtonsOpened!=1) {
					groupOfButtonsOpened = 1;
					setVisibilityOfReformsButton(groupOfButtonsOpened);
				}
			}
		});
		contreLeChomage.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (groupOfButtonsOpened!=2) {
					groupOfButtonsOpened=2;
					setVisibilityOfReformsButton(groupOfButtonsOpened);
				}
			}
		});
		construireUneEuropeDemocratique
				.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						if (groupOfButtonsOpened!=3) {
							groupOfButtonsOpened=3;
							setVisibilityOfReformsButton(groupOfButtonsOpened);
						}
					}
				});
		
		// Default opens for buttons of reforms :
		setVisibilityOfReformsButton(groupOfButtonsOpened);

		reformButton[0].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				execDisplayFileActivity(01);
			}
		});
		reformButton[1].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				execDisplayFileActivity(02);
			}
		});
		reformButton[2].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				execDisplayFileActivity(03);
			}
		});
		reformButton[3].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				execDisplayFileActivity(04);
			}
		});
		reformButton[4].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				execDisplayFileActivity(05);
			}
		});
		reformButton[5].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				execDisplayFileActivity(06);
			}
		});
		reformButton[6].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				execDisplayFileActivity(07);
			}
		});
		reformButton[7].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				execDisplayFileActivity(8);
			}
		});
		reformButton[8].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				execDisplayFileActivity(9);
			}
		});
		reformButton[9].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				execDisplayFileActivity(10);
			}
		});
		reformButton[10].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				execDisplayFileActivity(11);
			}
		});
		reformButton[11].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				execDisplayFileActivity(12);
			}
		});
		reformButton[12].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				execDisplayFileActivity(13);
			}
		});
		reformButton[13].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				execDisplayFileActivity(14);
			}
		});
		reformButton[14].setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				execDisplayFileActivity(15);
			}
		});

		ImageView pen2 = (ImageView) this.findViewById(R.id.pen2);
		countOfSignatures2TV = (TextView) this.findViewById(R.id.signatures2);
		countOfSignatures2TV.setText(Html.fromHtml(VG.countOfSignatures));
		countOfSignatures2TV.setBackgroundColor(VG.COLOR_YELLOW_WHITE);
		countOfSignatures2TV.setTextColor(VG.COLOR_BROWN);
		jeSigne2Button = (Button) this
				.findViewById(R.id.je_signe2);
		jeSigne2Button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Utils.execInternetBrowser(MainActivity.this,
						VG.jeSigneUrl);
			}
		});
		jeSigne2Button.setTextColor(VG.COLOR_BLACK);

		etApres2Button = (Button) this
				.findViewById(R.id.et_apres2);
		etApres2Button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Utils.execInternetBrowser(MainActivity.this,
						VG.etApresUrl);
			}
		});
		etApres2Button.setTextColor(VG.COLOR_BLACK);

		mesMentionsButton = (Button) this
				.findViewById(R.id.mes_mentions_button);
		mesMentionsButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);
				Utils.valorizeMessageOfMyMentions(VG.languageChoiced);
				builder.setTitle(VG.mesMentions_titre);
				builder.setMessage(VG.mesMentions_corps);
				AlertDialog alert = builder.create();
				alert.show();
			}
		});
	}

	/**
	 * Set visibility of buttons of reforms
	 * 
	 * @param visibilityStatut
	 * @param groupOfButtonsOpened
	 */
	protected void setVisibilityOfReformsButton(int groupOfButtonsOpened) {
		if (groupOfButtonsOpened >= 1 && groupOfButtonsOpened <= 3) {
			if (groupOfButtonsOpened == 1) {
				eviterLEffondrement.setClickable(false);
				eviterLEffondrement.setTextColor(VG.COLOR_BLACK);
				contreLeChomage.setClickable(true);
				contreLeChomage.setTextColor(VG.COLOR_WHITE);
				construireUneEuropeDemocratique.setClickable(true);
				construireUneEuropeDemocratique.setTextColor(VG.COLOR_WHITE);
				for (int i = 0; i <= 8; i++) {
					reformButton[i].setVisibility(View.VISIBLE);
				}
				for (int i = 9; i <= 12; i++) {
					reformButton[i].setVisibility(View.GONE);
				}
				for (int i = 13; i <= 14; i++) {
					reformButton[i].setVisibility(View.GONE);
				}
			} else if (groupOfButtonsOpened == 2) {
				eviterLEffondrement.setClickable(true);
				eviterLEffondrement.setTextColor(VG.COLOR_WHITE);
				contreLeChomage.setClickable(false);
				contreLeChomage.setTextColor(VG.COLOR_BLACK);
				construireUneEuropeDemocratique.setClickable(true);
				construireUneEuropeDemocratique.setTextColor(VG.COLOR_WHITE);
				for (int i = 0; i <= 8; i++) {
					reformButton[i].setVisibility(View.GONE);
				}
				for (int i = 9; i <= 12; i++) {
					reformButton[i].setVisibility(View.VISIBLE);
				}
				for (int i = 13; i <= 14; i++) {
					reformButton[i].setVisibility(View.GONE);
				}
			} else if (groupOfButtonsOpened == 3) {
				eviterLEffondrement.setClickable(true);
				eviterLEffondrement.setTextColor(VG.COLOR_WHITE);
				contreLeChomage.setClickable(true);
				contreLeChomage.setTextColor(VG.COLOR_WHITE);
				construireUneEuropeDemocratique.setClickable(false);
				construireUneEuropeDemocratique.setTextColor(VG.COLOR_BLACK);
				for (int i = 0; i <= 8; i++) {
					reformButton[i].setVisibility(View.GONE);
				}
				for (int i = 9; i <= 12; i++) {
					reformButton[i].setVisibility(View.GONE);
				}
				for (int i = 13; i <= 14; i++) {
					reformButton[i].setVisibility(View.VISIBLE);
				}
			}
		}
	}

	/**
	 * Zoom - Increase or decrease textsize
	 */
	protected void  zoomTextSize(int zoomCrease) {// increase, decrease...
		if (zoomCrease!=0) {
			if (zoomCrease < 0) {
				// If zoom < 0 and too small then no zoom !
				if (VG.textSizeOfTitleInButton + zoomCrease < 6
						|| VG.textSizeOfBodyInButton + zoomCrease < 6) {
				}
			}
			VG.textSizeOfTitleInButton += zoomCrease;
			VG.textSizeOfBodyInButton += zoomCrease;
			nousAvonsDecideDAgir_TitreTV
					.setTextSize(VG.textSizeOfTitleInButton);
			nousAvonsDecideDAgir_CorpsTV.setTextSize(VG.textSizeOfBodyInButton);
			nousSouhaitonsContribuerTV.setTextSize(VG.textSizeOfBodyInButton);
			direLExtremeGraviteTV.setTextSize(VG.textSizeOfBodyInButton);
			troisChantierTV.setTextSize(VG.textSizeOfTitleInButton);
			quinzeReformesTV.setTextSize(VG.textSizeOfTitleInButton);
			eviterLEffondrement.setTextSize(VG.textSizeOfTitleInButton);
			contreLeChomage.setTextSize(VG.textSizeOfTitleInButton);
			construireUneEuropeDemocratique
					.setTextSize(VG.textSizeOfTitleInButton);
			for (int i = 0; i < 15; i++) {
				reformButton[i].setTextSize(VG.textSizeOfBodyInButton);
			}
		}

	}

	/**
	 * Exec new page with reform choozed
	 * @param numReform
	 */
	protected void execDisplayFileActivity(int numReform) {
		Bundle bundle = new Bundle();
		bundle.putInt("numReform", numReform);
		Intent intent = new Intent(MainActivity.this, DisplayFileActivity.class);
		intent.putExtras(bundle);
		startActivityForResult(intent, 0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Il faudrait rafraîchir le menu pour qu'il prenne les valeurs de texte des différentes langues.
		menu.add(menuGroup1Id, menuSchemasId, menuSchemasId, VG.schemas);
		menu.add(menuGroup2Id, menuJeSigne2Id, menuJeSigne2Id,
				VG.jeSigne);
		menu.add(menuGroup3Id, menuLeCollectifId, menuLeCollectifId,
				VG.leCollectif);
		menu.add(menuGroup4Id, menuLaVideoId, menuLaVideoId, VG.laVideo);
		menu.add(menuGroup5Id, menuLesGroupesLocauxId, menuLesGroupesLocauxId,
				VG.lesGroupesLocaux);
		menu.add(menuGroup6Id, menuActualitesId, menuActualitesId,
				VG.actualites);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == menuSchemasId) {
			Intent intent = new Intent(MainActivity.this,
					DisplayImagesActivity.class);
			startActivityForResult(intent, 0);
			return true;
		} else if (item.getItemId() == menuJeSigne2Id) {
			Utils.execInternetBrowser(MainActivity.this, VG.jeSigneUrl);
			return true;
		} else if (item.getItemId() == menuLeCollectifId) {
			execDisplayFileActivity(00);
			return true;
		} else if (item.getItemId() == menuLaVideoId) {
			Utils.execInternetBrowser(MainActivity.this, VG.laVideoUrl);
			return true;
		} else if (item.getItemId() == menuLesGroupesLocauxId) {
			Utils.execInternetBrowser(MainActivity.this, VG.lesGroupesLocauxUrl);
			return true;
		} else if (item.getItemId() == menuActualitesId) {
			Utils.execInternetBrowser(MainActivity.this, VG.actualitesUrl);
			return true;
		} else {
			return false;
		}
	}

}
