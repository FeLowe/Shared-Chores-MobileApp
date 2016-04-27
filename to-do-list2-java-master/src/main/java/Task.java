import java.time.LocalDateTime;
import java.util.ArrayList;

public class Task {

  private static ArrayList<Task> allTasks = new ArrayList<Task>();
  private String mDescription;
  private Boolean mCompleted = false;
  private LocalDateTime mCreatedAt;
  private String mDayOfWeek;
  private int mId;


  public static ArrayList all() {
    return allTasks;
  }

  public Task(String description) {
    mDescription = description;
    mCreatedAt = LocalDateTime.now();
    allTasks.add(this);
    mId = allTasks.size();
  }

  public String getDescription() {
    return mDescription;
  }

  public Boolean isCompleted(){
    return mCompleted;
  }

  public LocalDateTime getCreatedAt(){
    return mCreatedAt;
  }
  public int getId(){
    return mId;
  }

  public static Task find(int id) {
    try {
      return allTasks.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public static void clear() {
    allTasks.clear();
  }


}
