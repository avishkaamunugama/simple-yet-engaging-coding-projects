package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.DirectoryChooser;
import javafx.util.Duration;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;




public class Controller implements Initializable {


    private String filePath;
    private String path;
    private int mediaCounter;
    private ArrayList<File> fileCollector = new ArrayList<>();
    private MediaPlayer mediaPlayer = null;
    private double speedRate = 1.0;

    private boolean clickPause = false;
    private boolean fullScrCheck = false;



    @FXML
    private MediaView mediaView;
    @FXML
    private Label duration;
    @FXML
    private Button openbtn;
    @FXML
    private Button playbtn;
    @FXML
    private Button pausebtn;
    @FXML
    private Button stopbtn;
    @FXML
    private Button previousbtn;
    @FXML
    private Button slowerbtn;
    @FXML
    private Button fasterbtn;
    @FXML
    private Button nextbtn;
    @FXML
    private Button contbtn;
    @FXML
    private Button exitbtn;
    @FXML
    private Button backward;
    @FXML
    private Button forward;
    @FXML
    private VBox vbox;
    @FXML
    private Label currentTime;
    @FXML
    private Slider volumeSlider;
    @FXML
    private Slider seekSlider;








    @FXML
    private void pause(ActionEvent e) {      //pause button

        mediaPlayer.pause();
        clickPause = true;
    }


    @FXML
    private void play(ActionEvent e) {    //play button

        mediaPlayer.play();
        titleSetter(mediaCounter);
        clickPause = false;

    }

    @FXML
    private void stop(ActionEvent e) {
        mediaPlayer.stop();
    }   //stop button

    @FXML
    private void before(ActionEvent e) {        //view prior video button

        mediaPlayer.pause();


        if (mediaCounter > 0) {

            try {
                mediaCounter--;
                playFile(fileCollector.get(mediaCounter));

            } catch (Exception er) {
//                System.out.println("This is the first video");
            }

        } else {
            Main.getStage().setTitle("This is the first file.No videos before this.");

        }
    }

    private void before() {
        mediaPlayer.pause();


        if (mediaCounter > 0) {

            try {
                mediaCounter--;
                playFile(fileCollector.get(mediaCounter));

            } catch (Exception er) {
//                System.out.println("This is the first video");
            }

        } else {
            Main.getStage().setTitle("This is the first file.No videos before this.");

        }
    }

    @FXML
    private void faster(ActionEvent e) {        //increase playback speed button
        speedRate += 0.5;
        mediaPlayer.setRate(speedRate);
    }

    private void faster() {        //increase playback speed button
        speedRate += 0.5;
        mediaPlayer.setRate(speedRate);
    }


    @FXML
    private void slower(ActionEvent e) {        //decrease playback speed button
        speedRate -= 0.5;
        mediaPlayer.setRate(speedRate);
    }

    private void slower() {        //decrease playback speed button
        speedRate -= 0.5;
        mediaPlayer.setRate(speedRate);
    }

    @FXML
    private void next(ActionEvent e) {      //view next video button
        mediaPlayer.pause();


        if (mediaCounter < (fileCollector.size() - 1)) {
            try {

                mediaCounter++;
                playFile(fileCollector.get(mediaCounter));

            } catch (Exception er) {
//                System.out.println("This is the last video");
            }
        } else {
            Main.getStage().setTitle("This is the last file.No more videos after this.");
        }
    }


    private void next() {      //view next video button
        mediaPlayer.pause();


        if (mediaCounter < (fileCollector.size() - 1)) {
            try {

                mediaCounter++;
                playFile(fileCollector.get(mediaCounter));

            } catch (Exception er) {
//                System.out.println("This is the last video");
            }
        } else {
            Main.getStage().setTitle("This is the last file.No more videos after this.");
        }
    }

    @FXML
    private void contLast(ActionEvent e) {

        try {
            mediaPlayer.pause();
        } catch (Exception ex) {
//            System.out.println("problem");
        }


        fileCollector.clear();

        mediaCounter = Integer.parseInt(Objects.requireNonNull(stateReader("stateFile1.txt")));


        String[] str = stateReader("stateFile2.txt").split(".mp4, ");


        for (String strPath : str) {

            strPath += ".mp4";
            File newFile = new File(strPath);
//            fileCollector.clear();
            fileCollector.add(newFile);
        }


        clickPause = false;


//        System.out.println(fileCollector.get(mediaCounter).getPath());
        playFile(fileCollector.get(mediaCounter));


        mediaPlayer.setOnReady(new Runnable() {
            @Override
            public void run() {
                startPlace();
            }
        });


    }


    private void startPlace() {
        mediaPlayer.seek(Duration.seconds(Integer.parseInt(Objects.requireNonNull(stateReader("stateFile3.txt")))));


        seekSlider.setMin(0.0);
        seekSlider.setValue(0.0);
        seekSlider.setMax(mediaPlayer.getTotalDuration().toSeconds());

        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {

            boolean isMouse = false;

            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {


                seekSlider.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        mediaPlayer.seek(Duration.seconds(seekSlider.getValue()));
                        isMouse = true;
                    }

                });

                if (isMouse == false) {
                    seekSlider.setValue(newValue.toSeconds());
                }

                seekSlider.setOnMouseReleased(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        isMouse=false;
                    }
                });


                double mediaDur = mediaPlayer.getTotalDuration().toSeconds();

                currentTime.setText(displayTime(newValue.toSeconds()));

                duration.setText(displayTime(mediaDur));



            }
        });

    }


    private void contLast() {

        try {
            mediaPlayer.pause();
        } catch (Exception ex) {
//            System.out.println("problem");
        }


        fileCollector.clear();

        mediaCounter = Integer.parseInt(Objects.requireNonNull(stateReader("stateFile1.txt")));


        String[] str = stateReader("stateFile2.txt").split(".mp4, ");


        for (String strPath : str) {

            strPath += ".mp4";
            File newFile = new File(strPath);
//            fileCollector.clear();
            fileCollector.add(newFile);
        }


        clickPause = false;


//        System.out.println(fileCollector.get(mediaCounter).getPath());
        playFile(fileCollector.get(mediaCounter));


        mediaPlayer.setOnReady(new Runnable() {
            @Override
            public void run() {
                startPlace();
            }
        });

    }

    @FXML
    private void exit(ActionEvent e) throws IOException {      //exit button


        stateWriter("stateFile1.txt", mediaCounter);
        stateWriter("stateFile2.txt", fileCollector);
        stateWriter("stateFile3.txt", (int) seekSlider.getValue());

        System.exit(0);
    }


    private void exit() throws IOException {      //exit button


        stateWriter("stateFile1.txt", mediaCounter);
        stateWriter("stateFile2.txt", fileCollector);
        stateWriter("stateFile3.txt", (int) seekSlider.getValue());

        System.exit(0);
    }


    @FXML
    private void buttonOpenFolder(ActionEvent event) {      //locate folder button

        fileCollector.clear();


        try {
            mediaPlayer.pause();

        } catch (Exception ex) {
//            System.out.println("problem");
            clickPause = true;
        }


        DirectoryChooser directoryChooser = new DirectoryChooser();         //gets the folder we select and assigns the path the filePath variable.
        directoryChooser.getInitialDirectory();
        File selectedDir = directoryChooser.showDialog(null);

        try {
            filePath = selectedDir.toString();

//        System.out.println(filePath);


            fileLister(filePath);       //this function finds all the videos in the given folder path.....Read more about this below.
            mediaCounter = 0;
            playFile(fileCollector.get(mediaCounter));      //plays the first video from the list.....Read more about this below.


//        System.out.println("Has a total of " + fileCollector.size() + " videos.");

        } catch (Exception e) {
            try {
                mediaPlayer.pause();
            } catch (Exception ex) {
//                System.out.println("problem");
            }
        }

    }


    private void buttonOpenFolder() {      //locate folder button

        fileCollector.clear();


        try {
            mediaPlayer.pause();

        } catch (Exception ex) {
//            System.out.println("problem");
            clickPause = true;
        }


        DirectoryChooser directoryChooser = new DirectoryChooser();         //gets the folder we select and assigns the path the filePath variable.
        directoryChooser.getInitialDirectory();
        File selectedDir = directoryChooser.showDialog(null);

        try {
            filePath = selectedDir.toString();

//        System.out.println(filePath);


            fileLister(filePath);       //this function finds all the videos in the given folder path.....Read more about this below.
            mediaCounter = 0;
            playFile(fileCollector.get(mediaCounter));      //plays the first video from the list.....Read more about this below.


//        System.out.println("Has a total of " + fileCollector.size() + " videos.");

        } catch (Exception e) {
            try {
                mediaPlayer.pause();
            } catch (Exception ex) {
//                System.out.println("problem");
            }
        }

    }


    public void forward(ActionEvent e) {
        double time = mediaPlayer.getCurrentTime().toSeconds() + ((mediaPlayer.getTotalDuration().toSeconds()) * 0.01);
        mediaPlayer.seek(Duration.seconds(time));

    }

    public void backward(ActionEvent e) {
        double time = mediaPlayer.getCurrentTime().toSeconds() - ((mediaPlayer.getTotalDuration().toSeconds()) * 0.01);
        mediaPlayer.seek(Duration.seconds(time));

    }

    public void forward() {
        double time = mediaPlayer.getCurrentTime().toSeconds() + ((mediaPlayer.getTotalDuration().toSeconds()) * 0.01);
        mediaPlayer.seek(Duration.seconds(time));

    }

    public void backward() {
        double time = mediaPlayer.getCurrentTime().toSeconds() - ((mediaPlayer.getTotalDuration().toSeconds()) * 0.01);
        mediaPlayer.seek(Duration.seconds(time));

    }


    //This function adds all video in the chosen directory to an array.
    private void fileLister(String filePath) {

//        System.out.println(filePath);
        File folder = new File(filePath);
        File[] listOfFiles = folder.listFiles();    //lists down all files and folders in the current folder

        if (listOfFiles != null) {      //only runs the code if the folder is not empty

            for (File i : listOfFiles) {        //one by one adds the files to array
                if (i.isFile()) {
                    String fileExt = "";

                    try {
                        fileExt = i.getName().substring((i.getName().length()) - 4);           //gets the extension of the file
                    } catch (Exception e) {
                    }


                    if (fileExt.equals(".mp4")) {           //validation to only add videos (mp4) to array by comparing file extension.
                        fileCollector.add(i);


                    }


                } else if (i.isDirectory()) {           //if the file is a folder/directory ,sets the path to that folder and runs the fileLister function again

                    path = i.getPath();
//                    System.out.println("This is a folder.    " + path);
                    fileLister(path);               //I have used recursion here so the program will go on finding videos through all sub-folders

                }

            }

        }


    }


    //To play the video file I used the java mediaPlayer
    private void playFile(File i) {


        Main.getStage().setTitle(i.getName());


//        System.out.println(i.toURI().toString());
//        System.out.println(i.getName());
        Media media = new Media(i.toURI().toString());          //Initiates the mediaPlayer
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);


        DoubleProperty width = mediaView.fitWidthProperty();        //Stretches the video vertically and horizontally to fit window height
        DoubleProperty height = mediaView.fitHeightProperty();

        width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));


        volumeSlider.setValue(mediaPlayer.getVolume() * 100);             //volume slider control
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mediaPlayer.setVolume(volumeSlider.getValue() / 100);
            }
        });


        mediaPlayer.play();         //Plays the video


        mediaPlayer.setOnReady(new Runnable() {
            @Override
            public void run() {


                //synchronises the slider with video play


                seekSlider.setMin(0.0);
                seekSlider.setValue(0.0);
                seekSlider.setMax(mediaPlayer.getTotalDuration().toSeconds());

                mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {

                    boolean isMouse = false;

                    @Override
                    public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {


                        seekSlider.setOnMousePressed(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                mediaPlayer.seek(Duration.seconds(seekSlider.getValue()));
                                isMouse = true;
                            }

                        });


                        if (isMouse == false) {
                            seekSlider.setValue(newValue.toSeconds());
                        }

                        seekSlider.setOnMouseReleased(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                isMouse=false;
                            }
                        });


                        double mediaDur = mediaPlayer.getTotalDuration().toSeconds();

                        currentTime.setText(displayTime(newValue.toSeconds()));

                        duration.setText(displayTime(mediaDur));



                    }
                });


            }
        });


    }


    private String displayTime(double secs) {


        int hrs = (int) secs / 3600;
        int remain = (int) secs - hrs * 3600;
        int mins = remain / 60;
        remain = remain - mins * 60;
        int sec = remain;


        String time = hrs + ":" + mins + ":" + sec;
        return time;
    }


    private void stateWriter(String txtPath, ArrayList<File> collector) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(txtPath, false));

        String toWrite = collector.toString();
        toWrite = toWrite.substring(1, toWrite.length() - 1);
        writer.write(toWrite);
        writer.close();
    }

    private void stateWriter(String txtPath, int mCount) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(txtPath, false));
        writer.write(String.valueOf(mCount));
        writer.close();
    }


    private String stateReader(String path) {

        BufferedReader br = null;

        try {
            String line;
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                return line;
            }
        } catch (IOException er) {
            er.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


        return null;
    }


    private void titleSetter(int number) {
        Main.getStage().setTitle(fileCollector.get(number).getName());
    }


    public PseudoClass onFullScr = PseudoClass.getPseudoClass("fullscreen");


    @Override
    public void initialize(URL url, ResourceBundle rb) {


        final Tooltip foldertt = new Tooltip();
        foldertt.setText("Choose folder");
        openbtn.setTooltip(foldertt);


        final Tooltip playtt = new Tooltip();
        playtt.setText("Play");
        playbtn.setTooltip(playtt);


        final Tooltip pausett = new Tooltip();
        pausett.setText("Pause");
        pausebtn.setTooltip(pausett);

        final Tooltip stoptt = new Tooltip();
        stoptt.setText("Stop");
        stopbtn.setTooltip(stoptt);


        final Tooltip prevtt = new Tooltip();
        prevtt.setText("Previous video");
        previousbtn.setTooltip(prevtt);


        final Tooltip slowtt = new Tooltip();
        slowtt.setText("- playback speed");
        slowerbtn.setTooltip(slowtt);


        final Tooltip fasttt = new Tooltip();
        fasttt.setText("+ playback speed");
        fasterbtn.setTooltip(fasttt);


        final Tooltip nexttt = new Tooltip();
        nexttt.setText("Next video");
        nextbtn.setTooltip(nexttt);


        final Tooltip rettt = new Tooltip();
        rettt.setText("Continue last played");
        contbtn.setTooltip(rettt);


        final Tooltip exittt = new Tooltip();
        exittt.setText("Save & exit");
        exitbtn.setTooltip(exittt);

        final Tooltip fortt = new Tooltip();
        fortt.setText("Skip forward");
        forward.setTooltip(fortt);

        final Tooltip backtt = new Tooltip();
        backtt.setText("Skip back");
        backward.setTooltip(backtt);


        mediaView.setOnMouseClicked(new EventHandler<MouseEvent>() {


            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    fullScrCheck = (!fullScrCheck);
                    vbox.pseudoClassStateChanged(onFullScr, fullScrCheck);

                } else if (event.getClickCount() == 1) {
                    clickPause = (!clickPause);
                    try {
                        if (clickPause == true) {
                            mediaPlayer.pause();
                        } else {
                            mediaPlayer.play();
                        }

                    } catch (Exception e) {
                    }
                }

            }
        });

    }


    public void keyhandler(KeyEvent event) {

        try {
            if ((event.getCode()).equals(KeyCode.ENTER)) {
                clickPause = (!clickPause);

                if (clickPause == true) {
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.play();
                }

            }

            if ((event.getCode()).equals(KeyCode.ESCAPE)) {

                vbox.pseudoClassStateChanged(onFullScr, false);
            }

            if ((event.getCode()).equals(KeyCode.SHIFT)) {
                fullScrCheck = (!fullScrCheck);
                vbox.pseudoClassStateChanged(onFullScr, fullScrCheck);
            }

            if ((event.getCode()).equals(KeyCode.COMMA)) {
                before();
            }

            if ((event.getCode()).equals(KeyCode.PERIOD)) {
                next();
            }

            if ((event.getCode()).equals(KeyCode.Z)) {
                slower();
            }

            if ((event.getCode()).equals(KeyCode.X)) {
                faster();
            }

            if ((event.getCode()).equals(KeyCode.TAB)) {
                buttonOpenFolder();
            }

            if ((event.getCode()).equals(KeyCode.Q)) {
                exit();
            }

            if ((event.getCode()).equals(KeyCode.W)) {
                contLast();
            }

            if ((event.getCode()).equals(KeyCode.N)) {
                backward();
            }

            if ((event.getCode()).equals(KeyCode.M)) {
                forward();
            }


        } catch (Exception e) {
        }

    }


}
