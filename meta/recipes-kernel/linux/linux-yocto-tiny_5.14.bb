KBRANCH ?= "v5.14/standard/tiny/base"
KBRANCH:qemuarm  ?= "v5.14/standard/tiny/arm-versatile-926ejs"

LINUX_KERNEL_TYPE = "tiny"
KCONFIG_MODE = "--allnoconfig"

require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "5.14.15"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "${@bb.utils.contains('ARCH', 'x86', 'elfutils-native', '', d)}"
DEPENDS += "openssl-native util-linux-native"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "2"

SRCREV_machine:qemuarm ?= "70f10165ff7c856cbf0512231ef9b6533efe1d1d"
SRCREV_machine ?= "f04b30fc1551e290fc169b2e2f2c799a0569aec5"
SRCREV_meta ?= "edb4dc09c55f317085688e3a5f6438ced46bc77d"

PV = "${LINUX_VERSION}+git${SRCPV}"

SRC_URI = "git://git.yoctoproject.org/linux-yocto.git;branch=${KBRANCH};name=machine \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.14;destsuffix=${KMETA}"

COMPATIBLE_MACHINE = "qemux86|qemux86-64|qemuarm|qemuarmv5"

# Functionality flags
KERNEL_FEATURES = ""

KERNEL_DEVICETREE:qemuarmv5 = "versatile-pb.dtb"
