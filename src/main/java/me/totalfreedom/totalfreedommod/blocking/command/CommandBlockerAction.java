package me.totalfreedom.totalfreedommod.blocking.command;

public enum CommandBlockerAction
{
<<<<<<< HEAD
=======

>>>>>>> devel
    BLOCK("b"),
    BLOCK_AND_EJECT("a"),
    BLOCK_UNKNOWN("u");
    private final String token;

<<<<<<< HEAD
    CommandBlockerAction(String token)
=======
    private CommandBlockerAction(String token)
>>>>>>> devel
    {
        this.token = token;
    }

<<<<<<< HEAD
=======
    public String getToken()
    {
        return this.token;
    }

>>>>>>> devel
    public static CommandBlockerAction fromToken(String token)
    {
        for (CommandBlockerAction action : CommandBlockerAction.values())
        {
            if (action.getToken().equalsIgnoreCase(token))
            {
                return action;
            }
        }
        return null;
    }
<<<<<<< HEAD

    public String getToken()
    {
        return this.token;
    }
=======
>>>>>>> devel
}
