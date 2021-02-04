/**
 * 
 */
package automation.page.element.ngs;

/**
 * @author Brahma
 *
 */
public enum ElementActionStatus {
	SUCCESS(0), ELEMENTNOTFOUND(1), ELEMENTCONFIGISSUE(2), DROPDOWNVALNOTFOUND(3), GENERICISSUE(4), OPTIONNOTFOUND(5);
	private final int actionStatus;

	ElementActionStatus(int actionStatus) {
		this.actionStatus = actionStatus;
	}

	public int getElementActionStatus() {
		return this.actionStatus;
	}
}
