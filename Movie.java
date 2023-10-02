import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Movie {
    private Date showingDate;
    private int cinemaNum;
    private Date timeStart;
    private boolean isPremiere;
    private String movieTitle;
    private double movieLength;
    private String[][] seats; // 2D array to represent seats
    private static final int ROWS = 8;
    private static final int SEATS_PER_ROW = 5;
    private ArrayList<Date> showtimes; // List to store movie showtimes

    public Movie(Date showingDate, int cinemaNum, Date timeStart, boolean isPremiere, String movieTitle, double movieLength) {
        this.showingDate = showingDate;
        this.cinemaNum = cinemaNum;
        this.timeStart = timeStart;
        this.isPremiere = isPremiere;
        this.movieTitle = movieTitle;
        this.movieLength = movieLength;
        this.seats = new String[ROWS][SEATS_PER_ROW];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                seats[i][j] = String.format("[%c%d]", 'A' + i, j + 1);
            }
        }

        this.showtimes = new ArrayList<>();
        // Adding default showtimes (you can modify these as needed)
        this.showtimes.add(timeStart);
        this.showtimes.add(new Date(timeStart.getTime() + 2 * 60 * 60 * 1000)); // 2 hours later
        this.showtimes.add(new Date(timeStart.getTime() + 4 * 60 * 60 * 1000)); // 4 hours later
        this.showtimes.add(new Date(timeStart.getTime() + 6 * 60 * 60 * 1000)); // 6 hours later
    }

    public String getMovieInfo() {
        return "Movie Title: " + movieTitle +
               "\nShowing Date: " + showingDate +
               "\nCinema Number: " + cinemaNum +
               "\nStart Time: " + timeStart +
               "\nIs Premiere: " + isPremiere +
               "\nMovie Length: " + movieLength + " hours";
    }

    public boolean isPremiere() {
        return isPremiere;
    }

    public String[][] getSeats() {
        return seats;
    }

    public void setSeats(String[][] seats) {
        this.seats = seats;
    }

    public void setSeatOccupancy(List<String> list) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                String seatCode = String.format("%c%d", 'A' + i, j + 1);
                if (list.contains(seatCode)) {
                    seats[i][j] = "[X]"; // Seat is occupied
                } else {
                    seats[i][j] = "[" + seatCode + "]"; // Seat label with seat code
                }
            }
        }
    }

    public void displaySeatAvailability() {
        // Display seat availability in the desired format
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tSCREEN");

        for (int i = 0; i < ROWS; i++) {
            System.out.print("|");
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                System.out.print("\t[" + seats[i][j] + "]");
            }
            System.out.println();
        }

        System.out.println("\nLegend: [LN] = Available Seat  ,  [X] = Seat Occupied");
    }

    // Getters and setters for showtimes
    public ArrayList<Date> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(ArrayList<Date> showtimes) {
        this.showtimes = showtimes;
    }

    public int getCinemaNum() {
        return cinemaNum;
    }
}