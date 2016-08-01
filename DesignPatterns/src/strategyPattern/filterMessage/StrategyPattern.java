package strategyPattern.filterMessage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StrategyPattern {
	public static void main(String args[]) {
		List<Message> messages = new ArrayList<>();
		messages.add(new Message(MessageType.TEXT, 100, "This is test message"));
		messages.add(new Message(MessageType.XML, 200, "How are you "));
		messages.add(new Message(MessageType.TEXT, 300, "Does Strategy pattern follows OCP design principle?"));
		messages.add(new Message(MessageType.TEXT, 400, "Wrong Message, should be filtered"));
		messages = filter(messages, new FilterBySize(200));
		messages = filter(messages, new FilterByType(MessageType.XML));
		messages = filter(messages, new FilterByKeyword("Wrong"));

		
		/*List<MessageForEnumStrategy> messagesForEnum = new ArrayList<>();
		messagesForEnum.add(new MessageForEnumStrategy(MessageType.TEXT, 100, "This is test message",
				FilteringStrategyEnum.FilterByKeyword));
		messagesForEnum.add(new MessageForEnumStrategy(MessageType.XML, 200, "How are you ",
				FilteringStrategyEnum.FilterByKeyword));
		messagesForEnum.add(new MessageForEnumStrategy(MessageType.TEXT, 300,
				"Does Strategy pattern follows OCP design principle?", FilteringStrategyEnum.FilterByKeyword));
		messagesForEnum.add(new MessageForEnumStrategy(MessageType.TEXT, 400, "Wrong Message, should be filtered",
				FilteringStrategyEnum.FilterByKeyword));
		*/
		//TODO: add the filter strategy for enum 
		
	}

	/*
	 * * This method confirms Open Closed design principle, * It's open for
	 * modification, because * you can provide any filtering criterion by
	 * providing * implementation of FilteringStrategy, but * no need to change
	 * any code here. * New functionality will be provided by new code.
	 */ public static final List<Message> filter(List<Message> messageList, FilteringStrategy strategy) {
		Iterator<Message> itr = messageList.iterator();
		while (itr.hasNext()) {
			Message msg = itr.next();
			if (strategy.isFilterable(msg)) {
				System.out.println(strategy.toString() + msg);
				itr.remove();
			}
		}
		return messageList;
	}
}
