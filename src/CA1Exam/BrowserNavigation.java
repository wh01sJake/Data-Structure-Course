package CA1Exam;

public class BrowserNavigation {
    private CustomStack<String> backStack;
    private CustomStack<String> forwardStack;
    private String currentPage;


    public BrowserNavigation() {
        backStack = new CustomStack<>();
        forwardStack = new CustomStack<>();
        currentPage = null;
    }

    public void visitPage(String url) {
        if(currentPage != null) {
            backStack.push(currentPage);
        }

        currentPage = url;

        System.out.println("Visit page " + url);
    }

    public void goBack() {
        if(backStack == null){
            System.out.println("Nothing to go back");
        }
        forwardStack.push(currentPage);
        currentPage = backStack.pop();
        System.out.println("Go back " + currentPage);
    }

    public void goForward() {
        if(forwardStack == null){
            System.out.println("Nothing to go forward");
        }
        backStack.push(currentPage);
        currentPage = forwardStack.pop();
        System.out.println("Go forward " + currentPage);
    }

    @Override
    public String toString() {
        String output = "";
        while(!backStack.isEmpty()) {
            output += backStack.top.data + " \n";
            backStack.top = backStack.top.next;
        }

        while(!forwardStack.isEmpty()) {
            output += forwardStack.top.data + " \n";
            forwardStack.top = forwardStack.top.next;
        }

        return output;
    }


    public static void main(String[] args) {
        BrowserNavigation bn = new BrowserNavigation();
        bn.visitPage("http://www.google.com");
        bn.visitPage("http://www.youtube.com");
        bn.visitPage("http://www.googleDocs.com");
        bn.visitPage("HomePage.com");
        bn.visitPage("Index1.com");
        bn.visitPage("Index2.com");
        bn.visitPage("Index3.com");
        bn.goBack();
        bn.goForward();
        System.out.println(bn);
    }
}
