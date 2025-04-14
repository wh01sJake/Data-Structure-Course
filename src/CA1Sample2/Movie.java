package CA1Sample2;

public class Movie {
    private String title;
    private String description;
    private String Genre;
    private int duration;
    private int rating;


    public Movie(String title, String description, String genre, int duration, int rating) {
        this.title = title;
        this.description = description;
        Genre = genre;
        this.duration = duration;
        this.setRating(rating);
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating > 5 || rating < 1) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.rating = rating;
    }

    @Override
    public String toString() {
        return
                "title=" + title + '\n' +
                 "description=" + description + '\n' +
                "Genre=" + Genre + '\n' +
                "duration=" + duration + '\n'+
                "rating=" + rating
               ;
    }
}
