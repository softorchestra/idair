DESCRIPTION = "Fiber Locator Server for Vivax-Metrotech"
LICENSE = "GPLv3+"
SECTION = "console/network"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
PR = "r3"
SRC_URI = "file://FLS.tgz"
# DEPENDS = ""

S = "${WORKDIR}/FLS"

inherit autotools update-rc.d

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME_${PN} = "orcatx"
INITSCRIPT_PARAMS_${PN} = "defaults 77 77"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d

	install -m 0775 ${WORKDIR}/FLS/orcatx.init   ${D}${sysconfdir}/init.d/orcatx
}

