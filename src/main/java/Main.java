import Entity.Category;
import Entity.Profile;
import Entity.Users;
import Entity.Video;
import Repository.CategoryRepository;
import Repository.UserRepository;
import Repository.VideoRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Users users = new Users("Rahul123","qwerty",new Profile("Rahul","Singh",24,"rahul@123.gmail.com","Haryana "));
        ArrayList<Video> videoArrayList = new ArrayList<>();

        UserRepository userRepository = new UserRepository();

        Video video = new Video("Java", "Learn java with cipherschools","https://www.cipherschools.com",new Date(),users);
        videoArrayList.add(video);
        users.setVideos(videoArrayList);
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Technical"));
        categories.add(new Category("Educational"));
        video.setCategories(categories);
        userRepository.saveUser(users);

        CategoryRepository repo = new CategoryRepository();
        for(Category category: categories){
            repo.saveCategory(category);
        }
        VideoRepository videoRepository = new VideoRepository();
        videoRepository.uploadVideo(video);
    }
}

