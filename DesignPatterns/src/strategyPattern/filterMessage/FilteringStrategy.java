package strategyPattern.filterMessage;

/*
 * interface which defines Strategy for this pattern.
 */
public interface FilteringStrategy {
	public boolean isFilterable(Message msg);
}

/*
 * An implementation of Strategy interface, which decides to filter message by
 * type.
 */
class FilterByType implements FilteringStrategy {
	private MessageType type;

	public FilterByType(MessageType type) {
		this.type = type;
	}
	
	@Override
	public boolean isFilterable(Message msg) {
		return type == msg.getType();
	}

	@Override
	public String toString() {
		return "Filtering By type: " + type;
	}

}

class FilterBySize implements FilteringStrategy {
	private int maxSize;

	public FilterBySize(int maxSize) {
		this.maxSize = maxSize;
	}

	@Override
	public boolean isFilterable(Message msg) {
		return msg.getSize() > maxSize;
	}

	@Override
	public String toString() {
		return "Filtering By maxSize: " + maxSize;
	}
}

class FilterByKeyword implements FilteringStrategy {
	private String keyword;

	public FilterByKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public boolean isFilterable(Message msg) {
		return msg.getContent() == null || msg.getContent().contains(keyword);
	}

	@Override
	public String toString() {
		return "Filtering By keyword: " + keyword;
	}
}
