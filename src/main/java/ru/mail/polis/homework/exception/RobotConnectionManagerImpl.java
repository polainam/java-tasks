package ru.mail.polis.homework.exception;

import java.util.Map;

public class RobotConnectionManagerImpl implements RobotConnectionManager {

    private final Map<Integer, Robot> robots;

    public RobotConnectionManagerImpl(Map<Integer, Robot> robots) {
        this.robots = robots;
    }

    @Override
    public RobotConnection getConnection(int robotId) throws RobotIdException, RobotConnectionException {
        Robot robot = robots.get(robotId);
        if (robotId < 0 || robot == null) {
            throw new RobotIdException("Invalid robot id");
        }
        return new RobotConnectionImpl(robot);
    }
}
