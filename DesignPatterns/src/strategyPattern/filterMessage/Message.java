package strategyPattern.filterMessage;

public class Message {
	private MessageType type;
	private int size;
	private String content;
	

	public Message(MessageType type, int size, String content) {
		this.type = type;
		this.size = size;
		this.content = content;
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
}
