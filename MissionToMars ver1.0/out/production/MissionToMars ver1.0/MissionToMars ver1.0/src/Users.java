/**
 * Class of the user in the Mission to Mars System
 */

public class Users {
    private int userID;
    private String password;
    private String characterType;

    public Users() {
    }

    public Users(int userID, String password, String characterType) {
        this.userID = userID;
        this.password = password;
        this.characterType = characterType;
    }

    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCharacterType() {
        return characterType;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    //设置该方法方便后面加载administrator的信息。
    public Administrator setAdministrator()
    {
        Administrator ad = new Administrator();
        ad.setUserID(userID);
        String[] adArray = MissionToMarsSystem.readFile("Administrator").split("\\n");
        for (int i = 0; i < adArray.length; i++){
            String[] adDetails = adArray[i].split(";");
            if (userID == Integer.valueOf(adDetails[0])){
                ad.setAdminName(adDetails[1]);
            }
        }
        return ad;
    }
}
