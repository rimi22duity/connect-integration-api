package net.therap.Connect.integration.api.enums;

import lombok.Getter;

/**
 * @author duity
 * @since 4/19/23
 */

@Getter
public enum DeviceModel {

    TC_SPV2("TC-SPV2", DeviceType.SMART_PLUG);

    private String name;

    private DeviceType deviceType;

    DeviceModel(String name, DeviceType deviceType) {
        this.name = name;
        this.deviceType = deviceType;
    }

    public static DeviceModel getDeviceModel(String name) {
        for (DeviceModel deviceModel : values()) {
            if (deviceModel.getName().equals(name)) {
                return deviceModel;
            }
        }

        return null;
    }
}
