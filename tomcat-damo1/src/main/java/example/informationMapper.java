package example;

import com.sun.tools.javac.Main;
import org.apache.ibatis.annotations.Param;

import javax.swing.event.ListDataEvent;
import java.util.List;

public interface informationMapper {
    userInformation search(@Param("username") String username,@Param("password") String password);

    userInformation searchP(String username);
    void addInf(userInformation users);
    List<MainInformation> searchTable();
    void addMInf(MainInformation mainInformation);
    void changeData(@Param("id") int id,@Param("else") MainInformation users);
    void deleteSingle(int id);
    void addTalk(TalkAbout talkAbout);
    List<String> selectTalkAll();
    void changeUsers(@Param("username") String username,@Param("password") String password);
    MainInformation selectAllInformation(int id);
    void addSug (suggestInformaition suggestinformaition);

    int selectTraffic(String traffic);
    int selectServe(String serve);
    int selectSave(String save);
    int selectActi(String acti);
    int selectBeaf(String beaf);
    int selectMaintain(String maintain);
    int selectElseL(String elseL);
    int selectPlay(String play);
    List<String> TrafficOF();
    List<String> ServeOF();
    List<String> SaveOF();
    List<String>  ActiOF();
    List<String> BeafOF();
    List<String> MaintainOF();
    List<String> PlayOF();
    List<String> ElseLOF();

}
