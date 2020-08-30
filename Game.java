import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
	JFrame window;
	JPanel titlePanel, startButtonPanel, questionPanel, answerPanel, questionsPanel;
	JLabel titleLabel, questionsLabel, questionNumberLabel;
	JButton startButton, answer1, answer2, answer3, answer4;
	Container con;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	JTextArea questionArea;
	int currentQuestion;
	String position;

	OnStart StartGame = new OnStart();
	AnswerChosen AnswerChosen = new AnswerChosen();
	public static void main(String[] args) {
		new Game();
	}
	public Game() {
		window = new JFrame();
		window.setTitle("Unknown's Quiz");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		window.setVisible(true);
		window.getContentPane().setBackground(Color.black);
		con = window.getContentPane();

		titlePanel = new JPanel();
		titlePanel.setBounds(100, 100, 600, 150);
		titlePanel.setBackground(Color.black);

		titleLabel = new JLabel("UNKNOWN'S QUIZ");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(titleFont);

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);

		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFocusPainted(false);
		startButton.setFont(normalFont);
		startButton.addActionListener(StartGame);

		titlePanel.add(titleLabel);
		startButtonPanel.add(startButton);

		con.add(titlePanel);
		con.add(startButtonPanel);
	}
	public void createGame() {
		startButtonPanel.setVisible(false);
		titlePanel.setVisible(false);

		questionPanel = new JPanel();
		questionPanel.setBounds(100, 100, 600, 250);
		questionPanel.setBackground(Color.black);
		con.add(questionPanel);

		questionArea = new JTextArea();
		questionArea.setBounds(100, 100, 600, 250);
		questionArea.setBackground(Color.black);
		questionArea.setForeground(Color.white);
		questionArea.setFont(normalFont);
		questionArea.setLineWrap(true);

		questionPanel.add(questionArea);

		answerPanel = new JPanel();
		answerPanel.setBounds(250, 350, 300, 150);
		answerPanel.setBackground(Color.black);
		answerPanel.setLayout(new GridLayout(4, 1));
		con.add(answerPanel);

		answer1 = new JButton();
		answer1.setBackground(Color.black);
		answer1.setForeground(Color.white);
		answer1.setFont(normalFont);
		answer1.setFocusPainted(false);
		answer1.addActionListener(AnswerChosen);
		answer1.setActionCommand("a1");
		answerPanel.add(answer1);

		answer2 = new JButton();
		answer2.setBackground(Color.black);
		answer2.setForeground(Color.white);
		answer2.setFont(normalFont);
		answer2.setFocusPainted(false);
		answer2.addActionListener(AnswerChosen);
		answer2.setActionCommand("a2");
		answerPanel.add(answer2);

		answer3 = new JButton();
		answer3.setBackground(Color.black);
		answer3.setForeground(Color.white);
		answer3.setFont(normalFont);
		answer3.setFocusPainted(false);
		answer3.addActionListener(AnswerChosen);
		answer3.setActionCommand("a3");
		answerPanel.add(answer3);

		answer4 = new JButton();
		answer4.setBackground(Color.black);
		answer4.setForeground(Color.white);
		answer4.setFont(normalFont);
		answer4.setFocusPainted(false);
		answer4.addActionListener(AnswerChosen);
		answer4.setActionCommand("a4");
		answerPanel.add(answer4);

		questionsPanel = new JPanel();
		questionsPanel.setBounds(100, 15, 600, 50);
		questionsPanel.setBackground(Color.black);
		questionsPanel.setLayout(new GridLayout(1, 4));
		con.add(questionsPanel);

		questionsLabel = new JLabel("Question: ");
		questionsLabel.setFont(normalFont);
		questionsLabel.setForeground(Color.white);
		questionsPanel.add(questionsLabel);

		questionNumberLabel = new JLabel();
		questionNumberLabel.setFont(normalFont);
		questionNumberLabel.setForeground(Color.white);
		questionsPanel.add(questionNumberLabel);

		gameSetup();
	}
	public void gameSetup() {
		currentQuestion = 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		question1();
	}
	public void lose() {
		position = "lose";

		questionArea.setText("Your answer was wrong! Restart the game?");

		answer2.setVisible(false);
		answer3.setVisible(false);
		answer4.setVisible(false);

		questionsPanel.setVisible(false);

		answer1.setText("Restart!"); //restart the game
		answer2.setText("");
		answer3.setText("");
		answer4.setText("");
	}
	public void win() {
		position = "win";

		questionArea.setText("Congratulations! You have won the game, do you wish to restart your progress?");

		answer2.setVisible(false);
		answer3.setVisible(false);
		answer4.setVisible(false);

		questionsPanel.setVisible(false);

		answer1.setText("Restart!"); //restart the game
		answer2.setText("");
		answer3.setText("");
		answer4.setText("");
	}
	public void question1() {
		position = "question1";

		currentQuestion = 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("Which one of these is the answer of this math\nproblem?\n\n7 + 8 * 5");

		answer1.setVisible(true);
		answer2.setVisible(true);
		answer3.setVisible(true);
		answer4.setVisible(true);

		questionsPanel.setVisible(true);

		answer1.setText("75");
		answer2.setText("45");
		answer3.setText("47"); //correct
		answer4.setText("50");
	}
	public void question2() {
		position = "question2";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("In what year was Discord made?");

		answer4.setVisible(false);

		answer1.setText("2014");
		answer2.setText("2015"); //correct
		answer3.setText("2016");
	}
	public void question3() {
		position = "question3";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("Which one is a coding application for Python?\n\nThere are 2 answers available for this question!");

		answer4.setVisible(true);

		answer1.setText("Sublime Text"); //correct
		answer2.setText("JetBrains");
		answer3.setText("Eclipse");
		answer4.setText("Visual Studio Code"); //correct
	}
	public void question4() {
		position = "question4";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("What is the 12th character in the Alphabet?");

		answer1.setText("M");
		answer2.setText("N");
		answer3.setText("L"); //correct
		answer4.setText("K");
	}
	public void question5() {
		position = "question5";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("A .zip archive is not extractable on Ubuntu");

		answer3.setVisible(false);
		answer4.setVisible(false);

		answer1.setText("True");
		answer2.setText("False"); //correct
		answer3.setText("");
		answer4.setText("");
	}
	public void question6() {
		position = "question6";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("What search engine does Firefox use?");

		answer3.setVisible(true);
		answer4.setVisible(true);

		answer1.setText("Bing");
		answer2.setText("Google"); //correct
		answer3.setText("Yahoo");
		answer4.setText("DuckDuckGo");
	}
	public void question7() {
		position = "question7";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("Which continent is Malaysia in?");

		answer1.setText("Asia"); //correct
		answer2.setText("Europe");
		answer3.setText("Africa");
		answer4.setText("America");
	}
	public void question8() {
		position = "question8";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("When is Google Chrome created?");

		answer1.setText("3/8/2008");
		answer2.setText("3/8/2009");
		answer3.setText("2/9/2009");
		answer4.setText("2/9/2008"); //correct
	}
	public void question9() {
		position = "question9";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("Microsoft isn't the creator of Bing, they bought\nthem");

		answer3.setVisible(false);
		answer4.setVisible(false);

		answer1.setText("True");
		answer2.setText("False"); //correct
		answer3.setText("");
		answer4.setText("");
	}
	public void question10() {
		position = "question10";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("Who is the tallest human ever in the world?");

		answer3.setVisible(true);
		answer4.setVisible(true);

		answer1.setText("John F. Carroll");
		answer2.setText("John Rogan");
		answer3.setText("Robert Wadlow"); //correct
		answer4.setText("Leonid Stadnyk");
	}
	public void question11() {
		position = "question11";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("Where is Venezuela located?");

		answer1.setText("South America"); //correct
		answer2.setText("North America");
		answer3.setText("East America");
		answer4.setText("West America");
	}
	public void question12() {
		position = "question12";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("When does Halloween occur?");

		answer1.setText("30/12");
		answer2.setText("31/10"); //correct
		answer3.setText("29/12");
		answer4.setText("30/10");
	}
	public void question13() {
		position = "question13";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("When does Christmas occur?");

		answer1.setText("24/12"); //correct
		answer2.setText("25/12"); //correct
		answer3.setText("30/10");
		answer4.setText("30/12");
	}
	public void question14() {
		position = "question14";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("Who created the game Super Hexagon?");

		answer1.setText("Vittorio Romeo");
		answer2.setText("Bennet Foddy");
		answer3.setText("Terry Cavanagh"); //correct
		answer4.setText("Chipzel");
	}
	public void question15() {
		position = "question15";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("Vittorio Romeo is the creator of the game Open\nHexagon");

		answer3.setVisible(false);
		answer4.setVisible(false);

		answer1.setText("True"); //correct
		answer2.setText("False");
		answer3.setText("");
		answer4.setText("");
	}
	public void question16() {
		position = "question16";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("When did Albert Einstein die?");

		answer3.setVisible(true);
		answer4.setVisible(true);

		answer1.setText("18/4/1945");
		answer2.setText("19/4/1945");
		answer3.setText("18/4/1955"); //correct
		answer4.setText("19/4/1955");
	}
	public void question17() {
		position = "question17";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("What is the capital of Tokyo?");

		answer1.setText("Shinjiku");
		answer2.setText("Shinjuku"); //correct
		answer3.setText("Shinkuju");
		answer4.setText("Shinkiju");
	}
	public void question18() {
		position = "question18";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("What is the capital of Australia?");

		answer1.setText("Canbera"); //correct
		answer2.setText("Canberia");
		answer3.setText("Cannbera");
		answer4.setText("Cannberia");
	}
	public void question19() {
		position = "question19";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("What is node.js made of?");

		answer1.setText("C");
		answer2.setText("C++");
		answer3.setText("Python");
		answer4.setText("JavaScript"); //correct
	}
	public void question20() {
		position = "question20";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("The shortcut key for copy on most computers is\nCTRL + V");

		answer3.setVisible(false);
		answer4.setVisible(false);

		answer1.setText("True");
		answer2.setText("False"); //correct
	}
	public void question21() {
		position = "question21";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("Who is the CEO of the Google company?");

		answer3.setVisible(true);
		answer4.setVisible(true);

		answer1.setText("Bill Gates");
		answer2.setText("Larry Page"); //correct
		answer3.setText("Jeff Bezos");
		answer4.setText("Elon Musk");
	}
	public void question22() {
		position = "question22";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("How many timezones are there in Russia?");

		answer1.setText("9");
		answer2.setText("10");
		answer3.setText("11"); //correct
		answer4.setText("12");
	}
	public void question23() {
		position = "question23";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("What is the capital city of India?");

		answer1.setText("Ottawa");
		answer2.setText("New Delhi"); //correct
		answer3.setText("Madrid");
		answer4.setText("Dublin");
	}
	public void question24() {
		position = "question24";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("What is the name of a food also can be known as a country's name?");

		answer1.setText("Turkey"); //correct
		answer2.setText("Chicken");
		answer3.setText("Spaghetti");
		answer4.setText("Cheese");
	}
	public void question25() {
		position = "question25";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("Is orange a color or a food?");

		answer4.setVisible(false);

		answer1.setText("Color");
		answer2.setText("Food");
		answer3.setText("Both"); //correct
		answer4.setText("");
	}
	public void question26() {
		position = "question26";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("What is stackoverflow.com made of?");

		answer4.setVisible(true);

		answer1.setText("HTML");
		answer2.setText("PHP");
		answer3.setText("C");
		answer4.setText("C#"); //correct
	}
	public void question27() {
		position = "question27";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("What is a baby kangaroo called?");

		answer1.setText("Kitten");
		answer2.setText("Joey"); //correct
		answer3.setText("Larva");
		answer4.setText("Chick");
	}
	public void question28() {
		position = "question28";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("What is the name of a sea creature that has 3\nhearts?\n\nThere are 2 answers available for this question!");

		answer1.setText("Cockroach");
		answer2.setText("Octopus"); //correct
		answer3.setText("Earthworm");
		answer4.setText("Squid"); //correct
	}
	public void question29() {
		position = "question29";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("What is one quarter of 1,000?");

		answer1.setText("125");
		answer2.setText("250"); //correct
		answer3.setText("375");
		answer4.setText("400");
	}
	public void question30() {
		position = "question30";

		currentQuestion = currentQuestion + 1;
		questionNumberLabel.setText(currentQuestion + "/30");

		questionArea.setText("Which ocean surrounds the Maldives?");

		answer1.setText("Arctic Ocean");
		answer2.setText("Indian Ocean"); //win
		answer3.setText("North Pacific Ocean");
		answer4.setText("South Pacific Ocean");
	}
	public class OnStart implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			createGame();
		}
	}
	public class AnswerChosen implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String choice = event.getActionCommand();

			switch(position) {
			case "lose":
				switch(choice) {
				case "a1": question1(); break;
				case "a2": break;
				case "a3": break;
				case "a4": break;
				}
				break;
			case "win":
				switch(choice) {
				case "a1": question1(); break;
				case "a2": break;
				case "a3": break;
				case "a4": break;
				}
				break;
			case "question1":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": lose(); break;
				case "a3": question2(); break;
				case "a4": lose(); break;
				}
				break;
			case "question2":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": question3(); break;
				case "a3": lose(); break;
				case "a4": break;
				}
				break;
			case "question3":
				switch(choice) {
				case "a1": question4(); break;
				case "a2": lose(); break;
				case "a3": lose(); break;
				case "a4": question4(); break;
				}
				break;
			case "question4":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": lose(); break;
				case "a3": question5(); break;
				case "a4": lose(); break;
				}
				break;
			case "question5":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": question6(); break;
				case "a3": break;
				case "a4": break;
				}
				break;
			case "question6":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": question7(); break;
				case "a3": lose(); break;
				case "a4": lose(); break;
				}
				break;
			case "question7":
				switch(choice) {
				case "a1": question8(); break;
				case "a2": lose(); break;
				case "a3": lose(); break;
				case "a4": lose(); break;
				}
				break;
			case "question8":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": lose(); break;
				case "a3": lose(); break;
				case "a4": question9(); break;
				}
				break;
			case "question9":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": question10(); break;
				case "a3": break;
				case "a4": break;
				}
				break;
			case "question10":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": lose(); break;
				case "a3": question11(); break;
				case "a4": lose(); break;
				}
				break;
			case "question11":
				switch(choice) {
				case "a1": question12(); break;
				case "a2": lose(); break;
				case "a3": lose(); break;
				case "a4": lose(); break;
				}
				break;
			case "question12":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": question13(); break;
				case "a3": lose(); break;
				case "a4": lose(); break;
				}
				break;
			case "question13":
				switch(choice) {
				case "a1": question14(); break;
				case "a2": question14(); break;
				case "a3": lose(); break;
				case "a4": lose(); break;
				}
				break;
			case "question14":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": lose(); break;
				case "a3": question15(); break;
				case "a4": lose(); break;
				}
				break;
			case "question15":
				switch(choice) {
				case "a1": question16(); break;
				case "a2": lose(); break;
				case "a3": break;
				case "a4": break;
				}
				break;
			case "question16":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": lose(); break;
				case "a3": question17(); break;
				case "a4": lose(); break;
				}
				break;
			case "question17":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": question18(); break;
				case "a3": lose(); break;
				case "a4": lose(); break;
				}
				break;
			case "question18":
				switch(choice) {
				case "a1": question19(); break;
				case "a2": lose(); break;
				case "a3": lose(); break;
				case "a4": lose(); break;
				}
				break;
			case "question19":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": lose(); break;
				case "a3": lose(); break;
				case "a4": question20(); break;
				}
				break;
			case "question20":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": question21(); break;
				case "a3": break;
				case "a4": break;
				}
				break;
			case "question21":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": question22(); break;
				case "a3": lose(); break;
				case "a4": lose(); break;
				}
				break;
			case "question22":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": lose(); break;
				case "a3": question23(); break;
				case "a4": lose(); break;
				}
				break;
			case "question23":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": question24(); break;
				case "a3": lose(); break;
				case "a4": lose(); break;
				}
				break;
			case "question24":
				switch(choice) {
				case "a1": question25(); break;
				case "a2": lose(); break;
				case "a3": lose(); break;
				case "a4": lose(); break;
				}
				break;
			case "question25":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": lose(); break;
				case "a3": question26(); break;
				case "a4": break;
				}
				break;
			case "question26":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": lose(); break;
				case "a3": lose(); break;
				case "a4": question27(); break;
				}
				break;
			case "question27":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": question28(); break;
				case "a3": lose(); break;
				case "a4": lose(); break;
				}
				break;
			case "question28":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": question29(); break;
				case "a3": lose(); break;
				case "a4": question29(); break;
				}
				break;
			case "question29":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": question30(); break;
				case "a3": lose(); break;
				case "a4": lose(); break;
				}
				break;
			case "question30":
				switch(choice) {
				case "a1": lose(); break;
				case "a2": win(); break;
				case "a3": lose(); break;
				case "a4": lose(); break;
				}
				break;
			}
		}
		}
}
