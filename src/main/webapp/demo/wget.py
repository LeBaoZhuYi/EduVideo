# coding=utf8
import re
import os
with open('student.html', 'r') as read:
    for data in read.readlines():
        href_re = re.match('.*href="([A-Za-z0-9:\/\._\-]+)\?.*"', data)
        src_re = re.match('.*src="([A-Za-z0-9:\/\._\-]+)\?.*"', data)
        murl = ''
        if href_re:
            murl = href_re.groups()[0]
        elif src_re:
            murl = src_re.groups()[0]
        if not murl:
            print 'error', data
            continue
        print murl
        os.system('wget ' + murl)
