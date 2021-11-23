import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScraperApplication_controller {
    @FXML
    private Button start_btn;
    @FXML
    private Button clear_btn;
    @FXML
    private TextField url;
    @FXML
    private TextField parent_id;
    @FXML
    private TextField parent_class;
    @FXML
    private TextField tag_name;
    @FXML
    private TextField attr;
    @FXML
    private TextArea console;

    @FXML
    private void handle_start(ActionEvent event) throws IOException{  
        Document doc = Jsoup.parse(new URL(url.getText()), 10000);
        try {
            if(!parent_id.getText().isEmpty()){
                System.out.println("by id");
                Element body = doc.getElementById(parent_id.getText());
                if(body == null)System.out.println("empty obje");
                Elements items = body.getElementsByTag(tag_name.getText());
                if(!items.isEmpty()){
                    for(Element item: items){
                        String src = item.attr(attr.getText());
                        console.appendText(src);
                        console.appendText("\n");
                    }
                    
                }else{
                    console.appendText("no matching items");
                }
    
            }else if(!parent_class.getText().isEmpty()){
                System.out.println("by class");
                Elements body = doc.getElementsByClass(parent_class.getText());
                System.out.println(body.size());
                for(Element each:body){
                    //System.out.println("here");
                    Elements items = each.getElementsByTag(tag_name.getText());
                    if(!items.isEmpty()){
                        for(Element item: items){
                            //System.out.println("there");
                            String src = item.attr(attr.getText());
                            console.appendText(src);
                            console.appendText("\n");
                        }
                        
                    }else{
                        console.appendText("no matching items");
                    }
                }
            }           
        } catch (Exception e) {
            e.printStackTrace();
        }

    

    }

    @FXML
    public void handle_clear(ActionEvent event){
        console.clear();
    }

}
