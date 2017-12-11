import os, re
with open('t', 'r') as file:
    for data in file.readlines():
        p = re.match('.*(images/[0-9a-zA-Z]+.png)', data)
        if p:
            p = p.groups()[0]
            os.system('wget http://demos.sucaihuo.com/modals/18/1833/demo/' + p)

