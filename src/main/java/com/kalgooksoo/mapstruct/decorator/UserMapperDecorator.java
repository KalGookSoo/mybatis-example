package com.kalgooksoo.mapstruct.decorator;

import com.kalgooksoo.command.UserCommand;
import com.kalgooksoo.mapstruct.UserMapper;
import com.kalgooksoo.model.User;

public class UserMapperDecorator implements UserMapper {

    /** Mapstruct Mapper delegate instance */
    private final UserMapper delegate;

    /**
     * UserMapperDecorator 생성자
     *
     * @param delegate Mapstruct Mapper delegate instance
     */
    public UserMapperDecorator(UserMapper delegate) {
        this.delegate = delegate;
    }

    /**
     * @see UserMapper#convert(UserCommand)
     */
    @Override
    public User convert(UserCommand userCommand) {
        User user = this.delegate.convert(userCommand);
        return user;
    }

    /**
     * @see UserMapper#convert(User)
     */
    @Override
    public UserCommand convert(User user) {
        UserCommand command = this.delegate.convert(user);
        return command;
    }

    /**
     * @see UserMapper#merge(User, UserCommand)
     */
    @Override
    public User merge(User user, UserCommand userCommand) {
        User mergedUser = this.delegate.merge(user, userCommand);
        return mergedUser;
    }
}
