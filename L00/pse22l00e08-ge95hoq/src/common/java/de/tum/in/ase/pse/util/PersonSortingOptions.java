package de.tum.in.ase.pse.util;

public class PersonSortingOptions {
	private SortingOrder sortingOrder = SortingOrder.ASCENDING;
	private SortField sortField = SortField.ID;

	public PersonSortingOptions() {
	}

	public PersonSortingOptions(SortField sortField) {
		this.sortField = sortField;
	}

	public PersonSortingOptions(SortingOrder sortingOrder, SortField sortField) {
		this.sortingOrder = sortingOrder;
		this.sortField = sortField;
	}

	public SortingOrder getSortingOrder() {
		return sortingOrder;
	}

	public void setSortingOrder(SortingOrder sortingOrder) {
		this.sortingOrder = sortingOrder;
	}

	public SortField getSortField() {
		return sortField;
	}

	public void setSortField(SortField sortField) {
		this.sortField = sortField;
	}

	public enum SortingOrder {
		ASCENDING, DESCENDING
	}

	public enum SortField {
		ID, FIRST_NAME, LAST_NAME, BIRTHDAY
	}
}
