package at.dumphey.itemeditor.utils;

import org.apache.commons.lang3.StringUtils;

public class NameUtils {

    public static String enumToFriendlyName(String $enum) {
        return StringUtils.capitalize($enum.replace("_", " ").toLowerCase());
    }

    public static <E extends Enum<E>> String enumToFriendlyName(E $enum) {
        return enumToFriendlyName($enum.name());
    }

}
