package assignments.week01.project.bretty.console.view;

import assignments.week01.project.io.Screen;

/**
 * The view that is used for a custom leaf functionality implementation.
 * It provides useful features like managed UI wrapper, e.g. {@code prompt()}
 * to prompt an input from the user with automatic validation.
 * Workflow of the default implementation:
 * 1) print title;
 * 2) execute custom action;
 * 3) pause
 * 4) go back to parent view
 */

public abstract class ActionView extends AbstractView {

    public ActionView(String runningTitle, String nameInParentMenu) {
        super(runningTitle, nameInParentMenu);
    }

    public ActionView(String runningTitle, String nameInParentMenu, ViewConfig viewConfig) {
        super(runningTitle, nameInParentMenu, viewConfig);
    }

    /**
     * to create your custom {@code ActionView} subclass, implement this method
     * to execute your custom logic between printing the title and go back to
     * the parent view
     */
    public abstract void executeCustomAction();

    @Override
    public void display() {
    	super.display();	// added to clear screen for each view
    	
        this.println();
        this.println(this.runningTitle);
        this.executeCustomAction();
//        this.pause();	// not necessarily the default desired behavior in my case - JWB
        this.goBack();
    }
}
