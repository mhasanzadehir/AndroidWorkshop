package ir.sharif.nightowls.models;

/**
 * Created by mahdihs76 on 5/31/18.
 */

public class Teacher {
    private String nickName;
    private String room;
    private String role;
    private String phoneNumber;
    private int imageResId;

    public Teacher(String nickName, String room, String role, String phoneNumber, int imageResId) {
        this.nickName = nickName;
        this.room = room;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.imageResId = imageResId;
    }

    public String getNickName() {
        return nickName;
    }

    public String getRoom() {
        return room;
    }

    public String getRole() {
        return role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getImageResId() {
        return imageResId;
    }
}
