package me.totalfreedom.totalfreedommod.command;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CommandParameters
{
<<<<<<< HEAD
=======

>>>>>>> devel
    String description();

    String usage();

    String aliases() default ""; // "alias1,alias2,alias3" - no spaces
<<<<<<< HEAD
}
=======
}
>>>>>>> devel
