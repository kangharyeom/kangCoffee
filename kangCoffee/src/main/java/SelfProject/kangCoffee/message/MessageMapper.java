package SelfProject.kangCoffee.message;


import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message messageDtoToMessage(MessagePostDto messagePostDto);
    MessageResponseDto messageToMessageResponseDto(Message message);
}
