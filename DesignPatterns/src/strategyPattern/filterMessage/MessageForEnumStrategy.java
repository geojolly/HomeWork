package strategyPattern.filterMessage;

public class MessageForEnumStrategy {
	private MessageType type;
	private int size;
	private String content;
	
	private FilteringStrategyEnum filteringStrategy;

	public MessageForEnumStrategy(MessageType type, int size, String content, FilteringStrategyEnum filteringStrategy ) {
		this.type = type;
		this.size = size;
		this.content = content;
		this.setFilteringStrategy(filteringStrategy);
	}

	public String getContent() {
		return content;
	}

	public int getSize() {
		return size;
	}

	public MessageType getType() {
		return type;
	}

	@Override
	public String toString() {
		return " Message{" + "type=" + type + ", size=" + size + ", content=" + content + '}';
	}

	public void setFilteringStrategy(FilteringStrategyEnum filteringStrategy) {
		this.filteringStrategy = filteringStrategy;
	}
}
