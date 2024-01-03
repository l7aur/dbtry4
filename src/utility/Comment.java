package utility;

/**
 * Comment class composed of the id of the item to be commented on, the comment itself and TODO the author
 */
public class Comment {
    private String id;
    private String commentText;
    /* Getters, Setters and Utility */
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCommentText() {
        return commentText;
    }
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
