import static org.junit.Assert.*;
 
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
 
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
 
import project.commons.Result;
import views.panel.AuthorSearchPanel;
import views.panel.FilterPanel;
import views.panel.KeywordsSearchPanel;
import views.panel.PapersSearchPanel;
import views.panel.ResultsPanel;
import views.panel.SearchPanel;
import views.panel.SearchViewFactory;
 
@SuppressWarnings("serial")
public class SearchViewFactoryTest extends JFrame{
    private SearchPanel searchPanel;
    private JSplitPane filterAndResultPanel;
    private JTable table;
    private JPanel searchPane = new JPanel();   
    private JPanel contentPane;
    private ResultsPanel resultView;
 
    @Test
    public void SearchViewFactoryTest()
    {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));
        SearchPanel searchPanel = new SearchPanel(contentPane);
        JScrollPane resultPane = new JScrollPane();
        List<Result> authorList = new ArrayList<Result>();
        Result r = new Result("Hina Shah", "Understanding Exception Handling: Viewpoints of Novices and Experts.", "2010", "db/journals/tse/tse36.html#ShahGH10", "1");
        authorList.add(r);
        resultView = new ResultsPanel(resultPane, authorList);      
        FilterPanel filterView = new FilterPanel(resultView.getTable());
        filterAndResultPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
                true, filterView, resultPane);
 
        SearchViewFactory factory = new SearchViewFactory(searchPane, searchPanel, table, contentPane, filterAndResultPanel);
        KeywordsSearchPanel ksp = (KeywordsSearchPanel) factory.createPanel("keywords");
        assertEquals(false, ksp == null );
 
        PapersSearchPanel psp = (PapersSearchPanel) factory.createPanel("papers");
        assertEquals(false, psp == null );
 
        AuthorSearchPanel asp = (AuthorSearchPanel) factory.createPanel("author");
        assertEquals(false, asp == null );
 
    }
 
}