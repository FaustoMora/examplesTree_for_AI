import networkx as nx
import matplotlib.pyplot as plt
G = nx.DiGraph()

G.add_node("ROOT")

for i in xrange(5):
    G.add_node("Child_%i" % i)

    for j in xrange(5):
        G.add_node("Grandchild_%i" % i + "." + str(j))
	
	for k in xrange(5):
            G.add_node("Greatgrandchild_%i" % i + "." + str(j) + "." + str(k))

for i in xrange(5):
    G.add_edge("ROOT", "Child_%i" % i)

    for j in xrange(5):
        G.add_edge("Child_%i" % i, "Grandchild_%i" % i + "." + str(j))
	
	for k in xrange(5):
            G.add_edge("Grandchild_%i" % i + "." + str(j), "Greatgrandchild_%i" % i + "." + str(j) + "." + str(k))


# write dot file to use with graphviz
# run "dot -Tpng test.dot >test.png"
nx.write_dot(G,'test.dot')

# same layout using matplotlib with no labels
plt.title("draw_networkx")
pos=nx.graphviz_layout(G,prog='dot')
nx.draw(G,pos,node_size=20,with_labels=False,arrows=False)
plt.savefig('nx_test.png')
